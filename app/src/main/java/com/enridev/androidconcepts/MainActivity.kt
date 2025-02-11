package com.enridev.androidconcepts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.enridev.androidconcepts.ui.theme.AndroidConceptsTheme
import com.enridev.check_internet.AndroidConnectivityObserver
import com.enridev.check_internet.ConnectivityViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidConceptsTheme {
                val viewModel = viewModel<ConnectivityViewModel> {
                    ConnectivityViewModel(
                        connectivityObserver = AndroidConnectivityObserver(
                            context = application
                        )
                    )
                }
                val isConnected by viewModel.isConnected.collectAsState()
                Scaffold { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Text(
                            text = "Connected? $isConnected"
                        )
                    }
                }
            }
        }
    }
}