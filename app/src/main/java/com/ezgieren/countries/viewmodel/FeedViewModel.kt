package com.ezgieren.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ezgieren.countries.model.Country

class FeedViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val country = Country("Turkey", "Asia","Ankara","TRY","Turkish","")
        val country2 = Country("France", "Europe","Paris","EUR","French","")
        val country3 = Country("Germany", "Europe","Berlin","EUR","German","")

        val countryList = arrayListOf<Country>(country,country2,country3)
        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }
}