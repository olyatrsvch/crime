package com.example.crime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CrimeDetailViewModel : ViewModel() {

    val currentCrimeState: MutableLiveData<Crime> by lazy {
        MutableLiveData<Crime>()
    }

    fun setDefaultCrime() {
        currentCrimeState.value = Crime(
            title = "Theft",
            id = 1,
            date = "03.12.2022",
            time = "01:59",
            isSolved = false
        )
    }

}