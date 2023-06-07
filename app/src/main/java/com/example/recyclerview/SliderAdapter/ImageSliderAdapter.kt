package com.example.recyclerview.SliderAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageSliderAdapter(private val imglist: MutableList<Int>):SliderViewAdapter<ImageSliderAdapter.ImageSliderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderViewHolder {
        var itemView = LayoutInflater.from(parent?.context).inflate(R.layout.image_slider, parent, false)
        return ImageSliderViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ImageSliderViewHolder?, position: Int) {

        if (viewHolder != null){

            Glide.with(viewHolder.itemView).load(imglist.get(position)).fitCenter().into(viewHolder.rvSliderImage)
        }

    }

    override fun getCount(): Int = imglist.size

    inner class ImageSliderViewHolder(itemView: View):ViewHolder(itemView){

        val rvSliderImage:ImageView = itemView.findViewById(R.id.imageSlider)

    }


}