package com.kapozzz.ip_test_task.data.room

import androidx.room.Dao
import androidx.room.Query
import com.kapozzz.ip_test_task.domain.models.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Query("SELECT * FROM Products")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM Products WHERE id = :id")
    suspend fun getProductById(id: String): Product

    @Query("SELECT * FROM Products WHERE title = :title")
    fun getProductByTitle(title: String): Flow<Product>

}