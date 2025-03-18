package com.kapozzz.ip_test_task.data.impl

import com.kapozzz.ip_test_task.data.room.ProductsDao
import com.kapozzz.ip_test_task.domain.models.Product
import com.kapozzz.ip_test_task.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsDao: ProductsDao
): ProductsRepository {

    override suspend fun getAllProducts(): Flow<List<Product>> = productsDao.getAllProducts()

    override suspend fun getProductById(id: String): Product = productsDao.getProductById(id)

    override suspend fun getProductByTitle(title: String): Flow<Product> = productsDao.getProductByTitle(title)

    override suspend fun insertProducts(products: List<Product>) = productsDao.insertProducts(products)

    override suspend fun updateProduct(product: Product) = productsDao.updateProduct(product)

    override suspend fun deleteProduct(id: String) = productsDao.deleteProduct(id)

}