package com.example.recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.BannerAdapter.BannerAdapter
import com.example.recyclerview.Holder.BaseViewHolder
import com.example.recyclerview.Model.FoodModel
import com.example.recyclerview.R
import com.example.recyclerview.SliderAdapter.ImageSliderAdapter
import com.smarteist.autoimageslider.SliderView
import java.lang.IllegalArgumentException

class ItemAdapter(private val context: Context):RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object{

        private const val TYPE_SLIDER = 0

        private const val TYPE_BANNER = 1

        private const val TYPE_ITEM = 2

    }

    val imageListBanner = mutableListOf<FoodModel>(

        FoodModel(1, "Black Cake", "$15.00", R.drawable.cake1),
        FoodModel(2, "Birth Cake", "$10.00", R.drawable.cake2),
        FoodModel(3, "Blue Cake", "$14.99", R.drawable.cake3),
        FoodModel(4, "Strawbery Cake", "$23.99", R.drawable.cake4)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
         return when(viewType){

             TYPE_SLIDER -> {
                 val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent, false)
                 return SliderViewHolder(itemView)
             }

             TYPE_BANNER -> {
                 val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.item_banner_recycler, parent, false)
                 return ItemBannerViewHolders(itemView)
             }

             TYPE_ITEM -> {
                 val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
                 return ItemViewHolder(itemView)

             }else -> throw IllegalArgumentException("Invalid")
         }
    }

    override fun getItemViewType(position: Int): Int {

        if (position == 0){
            return TYPE_SLIDER
        }else if (position == 1){
            return TYPE_BANNER
        }

        return TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return 5
    }



    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        if (getItemViewType(position) == TYPE_SLIDER){

            val imageList: MutableList<Int> = mutableListOf(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4
            )

            val sliderAdapter = ImageSliderAdapter(imageList)
            val itemView = (holder as SliderViewHolder)

            itemView.rvSlider.setSliderAdapter(sliderAdapter)
            itemView.rvSlider.isAutoCycle = true
            itemView.rvSlider.scrollTimeInSec = 5
            itemView.rvSlider.startAutoCycle()

        }


    }

    inner class SliderViewHolder(itemView: View):BaseViewHolder<View>(itemView){

        val rvSlider:SliderView = itemView.findViewById(R.id.image_slide)

        override fun bind(item: View) {

        }

    }

    inner class ItemBannerViewHolders(itemView: View):BaseViewHolder<View>(itemView){

        val rvBanner:RecyclerView = itemView.findViewById(R.id.item_bannerRecycler)

        init {

            val banner = BannerAdapter(context, imageListBanner)
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvBanner.layoutManager = layoutManager
            rvBanner.adapter = banner

        }

        override fun bind(item: View) {


        }

    }

    inner class ItemViewHolder(itemView: View):BaseViewHolder<View>(itemView){
        override fun bind(item: View) {

        }

    }



}