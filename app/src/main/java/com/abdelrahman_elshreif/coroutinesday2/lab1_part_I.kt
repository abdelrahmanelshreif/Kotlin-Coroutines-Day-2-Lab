package com.abdelrahman_elshreif.coroutinesday2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {

    val sharedFlow = MutableSharedFlow<Int>(replay = 0)

    sharedFlow.emit(1)
    sharedFlow.emit(2)

    launch {
        sharedFlow.collect {
            println("First Collector: $it")
        }
    }

    launch {
        sharedFlow.collect {
            println("Second Collector: $it")
        }
    }

    sharedFlow.emit(3)
    sharedFlow.emit(4)

    println("Done")
}
