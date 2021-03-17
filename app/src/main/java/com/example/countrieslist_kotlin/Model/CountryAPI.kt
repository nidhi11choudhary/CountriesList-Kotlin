package com.example.countrieslist_kotlin.Model

import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries() : Single<List<CountryModel>>
}