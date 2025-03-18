package com.kapozzz.ip_test_task.presentation.home

import androidx.compose.runtime.Stable
import com.kapozzz.ip_test_task.core.UiEffect
import com.kapozzz.ip_test_task.core.UiEvent
import com.kapozzz.ip_test_task.core.UiState
import com.kapozzz.ip_test_task.domain.models.Product

@Stable
data class HomeState(
    val products: List<Product>,
    val query: String,
    val interactItem: Product? = null,
    val isDeleteDialogVisible: Boolean = false,
    val isEditDialogVisible: Boolean = false
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
    data class OnOpenEditClick(val product: Product): HomeEvent()
    data class OnSaveEditClick(val count: Int): HomeEvent()
    data class OnOpenDeleteClick(val product: Product): HomeEvent()
    data object OnConfirmDeleteClick: HomeEvent()
    data object OnDismissEditClick: HomeEvent()
    data object OnDismissDeleteCLick: HomeEvent()
}

sealed class HomeEffect: UiEffect {

}