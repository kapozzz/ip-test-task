package com.kapozzz.ip_test_task.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kapozzz.ip_test_task.presentation.theme.IptesttaskTheme

@Composable
fun HomeSearchBar(
    query: String,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = { onSearch(it) },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        placeholder = { Text("Поиск товаров") },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
private fun HomeSearchBar() {
    IptesttaskTheme {
        HomeSearchBar(query = "", onSearch = {})
    }
}