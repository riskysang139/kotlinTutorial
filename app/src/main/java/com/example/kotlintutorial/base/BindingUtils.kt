package com.example.kotlintutorial.base

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView

@BindingAdapter("image")
fun loadImage(view: RoundedImageView, urlString: String) {
    Glide.with(view)
        .load(Constant.HEADER_URL_IMAGE + urlString)
        .into(view)
}