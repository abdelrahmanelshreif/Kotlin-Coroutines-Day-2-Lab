package com.abdelrahman_elshreif.coroutinesday2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val coroutineScope = CoroutineScope(Dispatchers.Default)

    val sharedFlow = flow<Int> {
        emit(1)
        emit(2)
        emit(3)
    }.shareIn(coroutineScope, started = SharingStarted.Lazily)

    launch {
        sharedFlow.collect {
            println("Hello Iam Coroutine listen to sharedFlow $it")
        }
    }
}
