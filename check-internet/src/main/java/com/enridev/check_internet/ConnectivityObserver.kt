package com.enridev.check_internet

import kotlinx.coroutines.flow.Flow


interface ConnectivityObserver {

    val isConnected: Flow<Boolean>
}