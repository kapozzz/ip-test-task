package com.kapozzz.ip_test_task.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kapozzz.ip_test_task.domain.models.Product

const val PRODUCTS_DATABASE_NAME = "products_database"
private const val PRODUCTS_DATABASE_VERSION = 1

@Database(entities = [Product::class], version = PRODUCTS_DATABASE_VERSION)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun userDao(): ProductsDao
}