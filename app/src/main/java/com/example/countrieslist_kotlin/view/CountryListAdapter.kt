package com.example.countrieslist_kotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieslist_kotlin.Model.CountryModel
import com.example.countrieslist_kotlin.R
import kotlinx.android.synthetic.main.item_countries.view.*

class  CountryListAdapter(var countries_adapter : ArrayList<CountryModel>) : RecyclerView.Adapter<CountryListAdapter.RecycleAdapterViewHolder>(){
        //this function will call from main activity to update country list whenever it needed


    fun updateList(updatedCountryList : List<CountryModel>){
            countries_adapter.clear()
            countries_adapter.addAll(updatedCountryList)
            notifyDataSetChanged()
        }

    //Need to create view holder class
        class RecycleAdapterViewHolder(view : View) : RecyclerView.ViewHolder(view){
            private val countryName = view.name
        private val capital = view.capital
        private val countryImage = view.image
        private val util  = Util()

        fun bind(countryModel: CountryModel){
            countryName.text = countryModel.countryName
            capital.text = countryModel.capital
            countryModel.flagPNG?.let { util.loadImage(countryImage, it, util.getProgressDrawable(countryImage.getContext())) };

        }
    }

    //this method will change the view of RecycleAdapterViewHolder and update it on view
    // this methos will return RecycleAdapterViewHolder so instead writing this (: RecycleAdapterViewHolder { TODO("Not yet implemented") }) we can use =
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecycleAdapterViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_countries, parent, false)
    )

        // We will provide the country list size
    override fun getItemCount() = countries_adapter.size


    override fun onBindViewHolder(holder: RecycleAdapterViewHolder, position: Int) {
        holder.bind(countries_adapter[position])
    }
}