package com.abdelrahman_elshreif.coroutinesday2.ui.theme

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val stateFlow = MutableStateFlow<Int>(0)

    launch {
        stateFlow.collect {
            println(it)
        }
    }

    stateFlow.value = 1
    stateFlow.value = 2
    stateFlow.value = 3
    stateFlow.value = 4
    stateFlow.value = 5
    stateFlow.value = 6

//    delay(1000)
}