package com.kapozzz.ip_test_task.di

import android.content.Context
import androidx.room.Room
import com.kapozzz.ip_test_task.data.room.PRODUCTS_DATABASE_NAME
import com.kapozzz.ip_test_task.data.room.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonModule {

    @Provides
    fun provideProductsDatabase(@ApplicationContext context: Context): ProductsDatabase =
        Room.databaseBuilder(context, ProductsDatabase::class.java, PRODUCTS_DATABASE_NAME).build()

    @Provides
    fun provideProductsDao(productsDatabase: ProductsDatabase) = productsDatabase.userDao()

}