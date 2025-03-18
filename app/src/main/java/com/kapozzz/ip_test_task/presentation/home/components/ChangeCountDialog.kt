package com.kapozzz.ip_test_task.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kapozzz.ip_test_task.R
import com.kapozzz.ip_test_task.presentation.theme.IptesttaskTheme

@Composable
fun ChangeCountDialog(
    count: Int,
    onAccept: (Int) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentCount = remember { mutableIntStateOf(count) }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier,
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                Text(text = stringResource(R.string.home_counter_title))
            }
        },
        text = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { if (currentCount.intValue > 0) currentCount.intValue -= 1 },
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Text(
                        text = stringResource(R.string.home_counter_minus),
                        style = MaterialTheme.typography.titleMedium,
                    )
                }

                Text(
                    text = currentCount.intValue.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )


                Button(
                    onClick = { currentCount.intValue += 1 },
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Text(
                        text = stringResource(R.string.home_counter_plus),
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onAccept(currentCount.intValue) }) {
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

@Preview
@Composable
private fun ChangeCountDialogPreview() {
    IptesttaskTheme {
        ChangeCountDialog(
            count = 5,
            onAccept = { newCount -> println("Accepted count: $newCount") },
            onDismiss = {}
        )
    }
}