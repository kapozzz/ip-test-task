package com.kapozzz.ip_test_task.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kapozzz.ip_test_task.domain.models.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Query("SELECT * FROM Products ORDER BY id ASC")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM Products WHERE id = :id")
    suspend fun getProductById(id: String): Product

    @Query("SELECT * FROM Products WHERE title = :title")
    fun getProductByTitle(title: String): Flow<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<Product>)

    @Query("DELETE FROM Products WHERE id = :id")
    suspend fun deleteProduct(id: String)

    @Update
    suspend fun updateProduct(product: Product)

}