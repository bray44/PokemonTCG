package com.example.pokemontcg

import androidx.paging.PagingSource
import com.example.pokemontcg.api.PokemonApiService
import com.example.pokemontcg.model.CardData
import retrofit2.HttpException
import java.io.IOException

class PokemonPagingSource(
    private val apiService: PokemonApiService
) : PagingSource<Int, CardData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val position = params.key ?: 1

        return try {
            val response = apiService.getPokemons(position, params.loadSize)
            val pokemons = response.results
            LoadResult.Page(
                data = pokemons,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (pokemons.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}

