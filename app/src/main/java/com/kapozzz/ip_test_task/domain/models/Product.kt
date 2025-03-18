@file:Suppress("DEPRECATION")

package com.kapozzz.ip_test_task.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey val id: String,
    val title: String,
    val dateOfAddition: Date,
    val labels: List<String>,
    val count: Int
) {
    companion object {
        val DEFAULT = Product(
            id = "",
            title = "",
            dateOfAddition = Date(),
            labels = emptyList(),
            count = 0
        )
    }
}

val mockProducts = listOf(
    Product("P001", "Смартфон X12", Date(2024 - 1900, 1, 15), listOf("электроника", "гаджеты"), 25),
    Product("P002", "Ноутбук Pro 15", Date(2024 - 1900, 3, 20), listOf("электроника", "компьютеры"), 12),
    Product("P003", "Кофе Арабика 500г", Date(2024 - 1900, 5, 10), listOf("еда", "напитки"), 150),
    Product("P004", "Футболка белая M", Date(2024 - 1900, 7, 1), listOf("одежда", "спорт"), 45),
    Product("P005", "Наушники Беспроводные", Date(2024 - 1900, 2, 28), listOf("электроника", "аудио"), 30),
    Product("P006", "Книга 'Программирование'", Date(2024 - 1900, 9, 15), listOf("книги", "обучение"), 20),
    Product("P007", "Часы умные FitPro", Date(2024 - 1900, 11, 5), listOf("электроника", "гаджеты"), 18),
    Product("P008", "Кресло офисное", Date(2024 - 1900, 4, 12), listOf("мебель", "офис"), 8),
    Product("P009", "Чай зеленый 100г", Date(2024 - 1900, 6, 23), listOf("еда", "напитки"), 80),
    Product("P010", "Рюкзак городской", Date(2024 - 1900, 8, 30), listOf("аксессуары", "спорт"), 35),
    Product("P011", "Монитор 27'", Date(2024 - 1900, 10, 17), listOf("электроника", "компьютеры"), 15),
    Product("P012", "Кроссовки беговые", Date(2025 - 1900, 0, 5), listOf("обувь", "спорт"), 25),
    Product("P013", "Лампа настольная", Date(2024 - 1900, 3, 8), listOf("мебель", "освещение"), 40),
    Product("P014", "Мышь беспроводная", Date(2024 - 1900, 5, 25), listOf("электроника", "компьютеры"), 60),
    Product("P015", "Плед теплый", Date(2024 - 1900, 11, 20), listOf("дом", "текстиль"), 22),
    Product("P016", "Клавиатура RGB", Date(2024 - 1900, 7, 14), listOf("электроника", "компьютеры"), 28),
    Product("P017", "Сумка для ноутбука", Date(2024 - 1900, 9, 3), listOf("аксессуары"), 33),
    Product("P018", "Блендер 600Вт", Date(2024 - 1900, 2, 10), listOf("техника", "кухня"), 10),
    Product("P019", "Шапка зимняя", Date(2024 - 1900, 10, 28), listOf("одежда", "зима"), 50),
    Product("P020", "Флешка 64ГБ", Date(2025 - 1900, 1, 15), listOf("электроника", "хранение"), 75)
)