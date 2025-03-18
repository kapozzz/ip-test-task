package com.kapozzz.ip_test_task

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kapozzz.ip_test_task.domain.models.mockProducts
import com.kapozzz.ip_test_task.domain.repositories.PreferencesRepository
import com.kapozzz.ip_test_task.domain.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository,
    private val productsRepository: ProductsRepository
): ViewModel() {

    init {
        isFirstStartValidate()
    }

    private fun isFirstStartValidate() {
        viewModelScope.launch(Dispatchers.IO) {
            if (preferencesRepository.isFirstStart()) {
                productsRepository.insertProducts(mockProducts)
            }
        }
    }

}