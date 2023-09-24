package com.example.pokemontcg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokemontcg.api.PokemonApiService
import com.example.pokemontcg.model.CardData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class PokemonViewModel(
    private val api: PokemonApiService,
    private val dao: PokemonCardDao
) : ViewModel() {

    // LiveData for Paging
    val cardList: Flow<PagingData<CardData>> = Pager(PagingConfig(pageSize = 20)) {
        PokemonCardPagingSource(api)
    }.flow.cachedIn(viewModelScope)

    // Function to fetch a single card's details
    fun getCardDetails(cardId: String) {
        viewModelScope.launch {
            val response = api.getCardDetails(cardId)
            // Handle the response (e.g., update LiveData)
        }
    }

    // Function to download a compressed image
    fun downloadCompressedImage(imageUrl: String) {
        viewModelScope.launch {
            // Implement image download logic
        }
    }

    // Function to refresh data
    fun refreshData() {
        // Invalidate the current paging data to force a refresh
    }

    // Function to search cards
    fun searchCards(query: String) {
        // Update your PagingSource or API call to include the query
    }

    // Function to save data for offline viewing
    fun saveDataOffline(cards: List<CardEntity>) {
        viewModelScope.launch {
            dao.insertAll(cards)
        }
    }

    // Function to load data from local database
    fun loadLocalData(): Flow<List<CardEntity>> {
        return dao.getAllCards()
    }
}
