package com.example.countrieslist_kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrieslist_kotlin.Model.CountryAPIServices
import com.example.countrieslist_kotlin.Model.CountryModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel(){

        private val countryService = CountryAPIServices()
         private val disposable = CompositeDisposable() // this view model is using RXjava to get the information
    // from service. when this view model closed, we need to close or clear the connection with this variable

    val countries = MutableLiveData<List<CountryModel>>()
    val countriesLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    // We'll always call refresh public method to get the details of fetchcountriesList
    fun refresh(){
        fetchcountriesList()
    }

    private fun fetchcountriesList(){

        loading.value = true
        disposable.add(
                countryService.getCountries()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<List<CountryModel>>(){
                            override fun onSuccess(value: List<CountryModel>) {
                                countries.value=value
                                countriesLoadError.value = false
                                loading.value = false
                            }

                            override fun onError(e: Throwable) {
                                countriesLoadError.value = true
                                loading.value = false
                            }

                        })
        )


       /* //Mock data
        val mockListData : List<CountryModel> = listOf(
                    CountryModel("country1"),
                    CountryModel("country2"),
                    CountryModel("country3"),
                    CountryModel("country4"),
                    CountryModel("country5")
        )

        countriesLoadError.value = false
        loading.value = false
        countries.value=mockListData*/
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}