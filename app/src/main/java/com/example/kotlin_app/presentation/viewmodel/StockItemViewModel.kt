package com.example.kotlin_app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_app.common.Resource
import com.example.kotlin_app.domain.use_case.GetStockItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StockItemViewModel@Inject constructor(val getStockItemUseCase: GetStockItemUseCase) : ViewModel() {
    private val _state = MutableStateFlow(StockItemState())
    val state: StateFlow<StockItemState> = _state

    init {
        getStockItem()
    }

    private fun getStockItem(symbol: String = "NVDA") {
        getStockItemUseCase(symbol).onEach { result ->
            _state.value = _state.value.update(result)
        }.launchIn(viewModelScope)
    }
}