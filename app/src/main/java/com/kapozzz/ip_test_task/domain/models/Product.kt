package com.kapozzz.ip_test_task.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey val id: String,
    val title: String,
    val dateOfAddition: Long,
    val labels: List<String>
)