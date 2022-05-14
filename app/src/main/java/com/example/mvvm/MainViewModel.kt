package com.example.mvvm

import androidx.lifecycle.ViewModel

class MainViewModel(startingCount: Int) : ViewModel() {
    private var count = startingCount

    fun getCurrentCount(): Int {
        return count
    }

    fun getUpdateCount(): Int {
        return ++count
    }

    fun resetCount(): Int {
        count = 0
        return count
    }
}