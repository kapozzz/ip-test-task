package com.kapozzz.ip_test_task.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kapozzz.ip_test_task.presentation.home.components.ChangeCountDialog
import com.kapozzz.ip_test_task.presentation.home.components.DeleteProductDialog
import com.kapozzz.ip_test_task.presentation.home.components.EmptyProducts
import com.kapozzz.ip_test_task.presentation.home.components.HomeSearchBar
import com.kapozzz.ip_test_task.presentation.home.components.HomeTopBar
import com.kapozzz.ip_test_task.presentation.home.components.ProductCard

@Composable
fun HomeScreen(
    state: HomeState,
    setEvent: (HomeEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Content(
            state = state,
            setEvent = setEvent,
            modifier = Modifier.fillMaxSize()
        )
        when {
            state.isEditDialogVisible -> {
                ChangeCountDialog(
                    count = state.interactItem?.count ?: 0,
                    onAccept = {
                        setEvent(HomeEvent.OnSaveEditClick(it))
                    },
                    onDismiss = {
                        setEvent(HomeEvent.OnDismissEditClick)
                    }
                )
            }
            state.isDeleteDialogVisible -> {
                DeleteProductDialog(
                    onAccept = {
                        setEvent(HomeEvent.OnConfirmDeleteClick)
                    },
                    onDismiss = {
                        setEvent(HomeEvent.OnDismissDeleteCLick)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Content(
    state: HomeState,
    setEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            stickyHeader {
                HomeTopBar()
            }
            item {
                HomeSearchBar(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    query = state.query,
                    onSearch = { query -> setEvent(HomeEvent.SearchQueryChanged(query)) }
                )
            }
            if (state.products.isEmpty()) item {
                EmptyProducts()
            }
            if (state.products.isNotEmpty()) items(
                items = state.products,
                key = { it.id }
            ) { product ->
                ProductCard(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .animateItem(fadeInSpec = null, fadeOutSpec = null),
                    product = product,
                    onEditClick = {
                        setEvent(HomeEvent.OnOpenEditClick(it))
                    },
                    onDeleteClick = {
                        setEvent(HomeEvent.OnOpenDeleteClick(it))
                    }
                )
                if (product.id == state.products.last().id) {
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}