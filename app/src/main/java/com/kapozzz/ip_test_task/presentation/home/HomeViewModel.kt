package com.kapozzz.ip_test_task.presentation.home

import androidx.lifecycle.viewModelScope
import com.kapozzz.ip_test_task.core.BaseViewModel
import com.kapozzz.ip_test_task.domain.models.Product
import com.kapozzz.ip_test_task.domain.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : BaseViewModel<HomeEvent, HomeState, HomeEffect>() {

    init {
        observeItems()
    }

    private val queryFlow = MutableStateFlow("")

    override fun createInitialState(): HomeState = HomeState.DEFAULT

    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SearchQueryChanged -> handleChangeQueryAction(event.query)
            is HomeEvent.OnOpenEditClick -> handleOnOpenEditClick(event.product)
            is HomeEvent.OnConfirmDeleteClick -> handleOnAcceptDeleteClick()
            is HomeEvent.OnSaveEditClick -> handleOnSaveEditClick(event.count)
            HomeEvent.OnDismissEditClick -> handleOnDismissEditClick()
            is HomeEvent.OnOpenDeleteClick -> handleOnAcceptDeleteClick(event.product)
            HomeEvent.OnDismissDeleteCLick -> handleOnDismissDeleteCLick()
        }
    }

    private fun observeItems() {
        viewModelScope.launch(Dispatchers.IO) {
            val productsFlow = productsRepository.getAllProducts()
            productsFlow
                .combine(queryFlow) { products, query ->
                    if (query.isNotEmpty()) filterProductsByQuery(products, query)
                    else products
                }
                .collect { products -> handleProducts(products) }
        }
    }

    private fun handleOnAcceptDeleteClick(product: Product) {
        setState { currentState.copy(interactItem = product, isDeleteDialogVisible = true) }
    }

    private fun handleOnDismissDeleteCLick() {
        setState { currentState.copy(interactItem = null, isDeleteDialogVisible = false) }
    }

    private fun handleOnAcceptDeleteClick() {
        viewModelScope.launch(Dispatchers.IO) {
            currentState.interactItem?.let { productsRepository.deleteProduct(it.id) }
            withContext(Dispatchers.Main) {
                setState { currentState.copy(interactItem = null, isDeleteDialogVisible = false) }
            }
        }
    }

    private fun handleOnSaveEditClick(count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            currentState.interactItem?.let {
                productsRepository.insertProducts(listOf(it.copy(count = count)))
            }
            withContext(Dispatchers.Main) {
                setState { currentState.copy(interactItem = null, isEditDialogVisible = false) }
            }
        }
    }

    private fun handleOnDismissEditClick() {
        setState { currentState.copy(interactItem = null, isEditDialogVisible = false) }
    }

    private fun handleOnOpenEditClick(product: Product) {
        setState { copy(interactItem = product, isEditDialogVisible = true) }
    }

    private fun filterProductsByQuery(
        products: List<Product>,
        query: String
    ) = products.filter { product ->
        product.title.lowercase().contains(query.lowercase())
    }

    private suspend fun handleProducts(products: List<Product>) {
        withContext(Dispatchers.Main) {
            setState { currentState.copy(products = products) }
        }
    }

    private fun handleChangeQueryAction(query: String) {
        setState { copy(query = query) }
        queryFlow.value = currentState.query
    }

}