package com.kapozzz.ip_test_task.presentation.home

import com.kapozzz.ip_test_task.core.UiEffect
import com.kapozzz.ip_test_task.core.UiEvent
import com.kapozzz.ip_test_task.core.UiState
import com.kapozzz.ip_test_task.domain.models.Product

data class HomeState(
    val products: List<Product>,
    val query: String
): UiState {
    companion object {
        val DEFAULT = HomeState(
            products = emptyList(),
            query = ""
        )
    }
}

sealed class HomeEvent: UiEvent {
    data class SearchQueryChanged(val query: String): HomeEvent()
}

sealed class HomeEffect: UiEffect {

}