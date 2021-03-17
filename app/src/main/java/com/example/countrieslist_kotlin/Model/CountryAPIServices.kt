package com.example.countrieslist_kotlin.Model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryAPIServices { //Create a service and call the function getCiuntries()

    private val BASE_URL = "https://raw.githubusercontent.com"
    private val API : CountryAPI

    init {
        API = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(CountryAPI :: class.java)
    }

    fun getCountries() : Single<List<CountryModel>>{ //this function will simply return the list of countries
        return API.getCountries()
    }
}