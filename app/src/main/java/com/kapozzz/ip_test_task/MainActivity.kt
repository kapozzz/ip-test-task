package com.kapozzz.ip_test_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.kapozzz.ip_test_task.presentation.home.HomeScreen
import com.kapozzz.ip_test_task.presentation.home.HomeViewModel
import com.kapozzz.ip_test_task.presentation.theme.IptesttaskTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel: MainViewModel = hiltViewModel()
            IptesttaskTheme {
                val viewModel: HomeViewModel = hiltViewModel()
                HomeScreen(state = viewModel.uiState.collectAsState().value, setEvent = viewModel::setEvent)
            }
        }
    }


}