package com.kapozzz.ip_test_task.core

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toFormattedString(): String {
    val formatter = SimpleDateFormat("MM.dd.yyyy", Locale.getDefault())
    return formatter.format(this)
}