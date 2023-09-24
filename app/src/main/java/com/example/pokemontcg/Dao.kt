package com.example.pokemontcg

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cards: List<CardEntity>)

    @Query("SELECT * FROM pokemon_cards")
    fun getAllCards(): Flow<List<CardEntity>>

    @Query("SELECT * FROM pokemon_cards WHERE name LIKE :query")
    fun searchCards(query: String): Flow<List<CardEntity>>
}
