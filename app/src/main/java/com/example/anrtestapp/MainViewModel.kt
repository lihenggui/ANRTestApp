package com.example.anrtestapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel: ViewModel() {
    val stateList = mutableStateListOf<Pair<String, String>>()

    init {
        init()
    }

    private fun init() = viewModelScope.launch(Dispatchers.IO) {
        delay(100)
        for (i in 0..1000) {
            stateList.add(Pair("Name $i", "Summary $i"))
        }
        delay(100)
        for (i in 0..1000) {
            stateList[i] = Pair("Name $i+1", "Summary $i+1")
        }
        delay(1000)
        do {
            val random = Random(System.currentTimeMillis())
            for (j in 0..1000) {
                stateList[j] = Pair("Name ${random.nextInt()}", "Summary ${random.nextInt()}")
            }
        } while (true)
    }
}