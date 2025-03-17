package com.kapozzz.ip_test_task.domain.repositories

import com.kapozzz.ip_test_task.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getAllProducts(): Flow<Product>

    suspend fun getProductById(id: String): Product

    suspend fun getProductByTitle(title: String): Flow<Product>

}