package com.ezgieren.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ezgieren.countries.model.Country

class CountryViewModel : ViewModel() {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("Turkey","Asia","Ankara","TRY","Turkish","")
        countryLiveData.value = country
    }
}