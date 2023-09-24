package com.example.pokemontcg

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokemontcg.api.PokemonApiService
import java.util.concurrent.Flow

class PokemonCardRepository(private val apiService: PokemonApiService, private val dao: PokemonCardDao) {
    fun getCards(): Flow<PagingData<PokemonCardEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { dao.getAllCards() }
        ).flow
    }
}
