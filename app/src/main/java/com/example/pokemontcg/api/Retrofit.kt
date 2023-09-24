package com.example.pokemontcg.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.pokemontcg.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }
}


