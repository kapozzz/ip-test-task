package com.kapozzz.ip_test_task.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kapozzz.ip_test_task.R

@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(86.dp)
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(top = 48.dp),
            text = stringResource(R.string.home_products_top_bar_title),
            color = Color.White,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
        )
    }
}

@Preview
@Composable
private fun TobBarPreview() {
    HomeTopBar()
}