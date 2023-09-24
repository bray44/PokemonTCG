package com.example.pokemontcg

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CardEntity::class], version = 1, exportSchema = false)
abstract class PokemonCardDatabase : RoomDatabase() {

    abstract fun pokemonCardDao(): PokemonCardDao

    companion object {
        @Volatile
        private var INSTANCE: PokemonCardDatabase? = null

        fun getDatabase(context: Context): PokemonCardDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokemonCardDatabase::class.java,
                    "pokemon_card_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
