package com.example.pokemontcg.model

data class PokemonCardListResponse(
    val data: List<CardData>,
    val page: Int,
    val pageSize: Int,
    val count: Int,
    val totalCount: Int
)

data class CardData(
    val id: String,
    val name: String,
    val supertype: String,
    val subtypes: List<String>,
    val hp: String,
    val types: List<String>,
    val evolvesTo: List<String>,
    val rules: List<String>,
    val attacks: List<Attack>,
    val weaknesses: List<Weakness>,
    val retreatCost: List<String>,
    val convertedRetreatCost: Int,
    val set: SetInfo,
    val number: String,
    val artist: String,
    val rarity: String,
    val nationalPokedexNumbers: List<Int>,
    val legalities: Legalities,
    val images: CardImages,
    val tcgplayer: TcgPlayer
)
