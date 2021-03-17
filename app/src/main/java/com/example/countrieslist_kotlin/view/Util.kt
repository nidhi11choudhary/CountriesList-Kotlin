package com.example.countrieslist_kotlin.view

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.countrieslist_kotlin.R

class Util
{

        fun loadImage(image : ImageView, url : String, progressDrawable : CircularProgressDrawable){
            val options = RequestOptions()
                    .placeholder(progressDrawable)
                    .error(R.mipmap.ic_launcher_round)
            Glide.with(image.getContext()).setDefaultRequestOptions(options)
                    .load(url).into(image)
        }


    fun getProgressDrawable(context : Context) : CircularProgressDrawable {
        val drawable = CircularProgressDrawable(context)
             drawable.strokeWidth = 10f
             drawable.centerRadius = 50f
             drawable.start()
        return drawable
    }
}