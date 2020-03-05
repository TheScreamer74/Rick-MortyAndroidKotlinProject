package com.example.rick_mortyandroidkotlinproject.ui.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso



@BindingAdapter("image")
fun bindImage(imgView: ImageView, imgUrl: String?) {
        Picasso.get()
            .load(imgUrl)
            .into(imgView)
    }