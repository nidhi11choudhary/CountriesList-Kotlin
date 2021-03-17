package com.example.countrieslist_kotlin.Model

import com.google.gson.annotations.SerializedName

data class CountryModel(
       @SerializedName("name") val countryName :String?,
        @SerializedName("capital") val capital :String?,
        @SerializedName("flagPNG") val flagPNG :String? )
