package com.kapozzz.ip_test_task.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kapozzz.ip_test_task.R

@Composable
fun DeleteProductDialog(
    onAccept: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Icon(imageVector = Icons.Default.Warning, contentDescription = null)
                Text(text = stringResource(R.string.home_delete_dialog_title))
            }
        },
        text = {
            Text(
                text = stringResource(R.string.home_delete_dialog_body),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        },
        confirmButton = {
            TextButton(onClick = { onAccept() }) {
                Text(
                    stringResource(R.string.home_counter_accept),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text(
                    stringResource(R.string.home_counter_dismiss),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    )
}