package com.example.kotlin_app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_app.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :ViewModel() {
    private val _state = MutableStateFlow(CoinsListState())
    val state: StateFlow<CoinsListState> = _state
    init {
        getCoins()
    }
    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            _state.value = _state.value.fromResource(result)
        }.launchIn(viewModelScope)
    }
}