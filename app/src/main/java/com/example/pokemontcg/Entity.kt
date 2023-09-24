package com.example.pokemontcg

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_cards")
data class CardEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val imageUrl: String,
    // Add other fields you need
)
