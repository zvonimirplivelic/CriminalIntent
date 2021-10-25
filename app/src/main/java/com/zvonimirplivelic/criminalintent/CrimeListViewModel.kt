package com.zvonimirplivelic.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.*

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
    init {
        viewModelScope.launch {
            insertData()
        }
    }

    private suspend fun insertData() {
        val crime = Crime(UUID.randomUUID(), "prvi", Date(), true)
        crimeRepository.addCrime(crime)
    }
}