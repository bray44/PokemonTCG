package com.example.pokemontcg.api

import com.example.pokemontcg.model.PokemonCardListResponse
import com.example.pokemontcg.model.PokemonDetailedCardResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("cards")
    suspend fun getCardList(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 20
    ): Response<PokemonCardListResponse>

    @GET("cards/{id}")
    suspend fun getDetailedCard(
        @Path("id") id: String
    ): Response<PokemonDetailedCardResponse>


}

