package com.kapozzz.ip_test_task.presentation.home

import androidx.lifecycle.viewModelScope
import com.kapozzz.ip_test_task.core.BaseViewModel
import com.kapozzz.ip_test_task.domain.models.Product
import com.kapozzz.ip_test_task.domain.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
): BaseViewModel<HomeEvent, HomeState, HomeEffect>() {

    init {
        observeItems()
    }

    override fun createInitialState(): HomeState = HomeState.DEFAULT

    override fun handleEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.SearchQueryChanged -> handleChangeQueryAction(event.query)
        }
    }

    private fun observeItems() {
        viewModelScope.launch {
            val productsFlow = productsRepository.getAllProducts()
            productsFlow
                .map { products -> products.filter { product -> product.title.contains(currentState.query) } }
                .flowOn(Dispatchers.Default)
                .collect { products -> handleProducts(products) }
        }
    }

    private fun handleProducts(products: List<Product>) {
        setState { currentState.copy(products = products) }
    }

    private fun handleChangeQueryAction(query: String) {
        setState { copy(query = query) }
    }

}