package com.example.pokemontcg.model

data class PokemonDetailedCardResponse(
    val data: PokemonDetailedCard
)

data class PokemonDetailedCard(
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

data class Attack(
    val name: String,
    val cost: List<String>,
    val convertedEnergyCost: Int,
    val damage: String,
    val text: String
)

data class Weakness(
    val type: String,
    val value: String
)

data class SetInfo(
    val id: String,
    val name: String,
    val series: String,
    val printedTotal: Int,
    val total: Int,
    val legalities: Legalities,
    val ptcgoCode: String,
    val releaseDate: String,
    val updatedAt: String,
    val images: SetImages
)

data class SetImages(
    val symbol: String,
    val logo: String
)

data class Legalities(
    val unlimited: String,
    val expanded: String
)

data class CardImages(
    val small: String,
    val large: String
)

data class TcgPlayer(
    val url: String,
    val updatedAt: String,
    val prices: Prices
)

data class Prices(
    val holofoil: Holofoil
)

data class Holofoil(
    val low: Double,
    val mid: Double,
    val high: Double,
    val market: Double,
    val directLow: Double
)



