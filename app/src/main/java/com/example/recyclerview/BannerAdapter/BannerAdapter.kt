package com.example.recyclerview.BannerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Model.FoodModel
import com.example.recyclerview.R

class BannerAdapter(private val context: Context, private val list: MutableList<FoodModel>):RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {

        val foodtitle = holder.itemView.findViewById<TextView>(R.id.titleBanner)
        foodtitle.setText(list[position].foodtitle)

        val foodprice = holder.itemView.findViewById<TextView>(R.id.titlePrice)
        foodprice.setText(list[position].foodprice)

        val imageIcon = holder.itemView.findViewById<ImageView>(R.id.imageBanner)
        imageIcon.setImageResource(list[position].imageIcon)

    }
    inner class BannerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}