package com.kapozzz.ip_test_task.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kapozzz.ip_test_task.R
import com.kapozzz.ip_test_task.core.toFormattedString
import com.kapozzz.ip_test_task.domain.models.Product
import com.kapozzz.ip_test_task.presentation.theme.IptesttaskTheme

@Composable
fun ProductCard(
    product: Product,
    onEditClick: (Product) -> Unit,
    onDeleteClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(164.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(8.dp),
                clip = true
            )
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                ProductTitle(product, onEditClick, onDeleteClick)
                ProductLabels(product)
            }
            ProductDescription(product)
        }
    }
}

@Composable
private fun ProductDescription(product: Product) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.home_product_card_on_storage),
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = product.count.toString(),
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Light),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Дата добавления",
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = product.dateOfAddition.toFormattedString(),
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Light),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun ProductLabels(product: Product) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        product.labels.forEach { label ->
            SuggestionChip(
                onClick = { /* ignore */ },
                enabled = false,
                label = { Text(text = label) },
                modifier = Modifier.height(32.dp)
            )
        }
    }
}

@Composable
private fun ProductTitle(
    product: Product,
    onEditClick: (Product) -> Unit,
    onDeleteClick: (Product) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = product.title,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary,
            maxLines = 1
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            IconButton({ onEditClick(product) }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            IconButton({ onDeleteClick(product) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    IptesttaskTheme {
        ProductCard(product = Product(
            id = "",
            title = "iPhone 13",
            dateOfAddition = java.util.Date(),
            count = 176,
            labels = listOf(
                "Телефон",
                "Apple",
                "Аксессуары",
                "Аксессуары",
                "Телефон",
                "Apple"
            )
        ), {}, {})
    }
}