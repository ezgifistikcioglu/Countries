package com.ezgieren.countries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ezgieren.countries.model.Country

@Dao
interface CountryDAO {
    // Insert -> Insert Into
    // suspend -> Coroutine'ler icinde cagirilir,Pause & Continue
      ///  fonksiyonları durdurup devam ettirmeye olanak veren keyword
    // vararg -> Farklı sayıda ki objeleri teslim eder (multiple country objects)
    // List<Long> -> primary keys
    @Insert
    suspend fun insertAll(vararg countries : Country) : List<Long>

    @Query("SELECT * FROM country")
    suspend fun getAllCountries() :List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int) : Country

    @Query("DELETE from country")
    suspend fun deleteAllCountries()
}