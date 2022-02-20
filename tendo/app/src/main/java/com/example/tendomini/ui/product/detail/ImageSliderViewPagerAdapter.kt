package com.example.tendomini.ui.product.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.databinding.ItemImageSliderBinding

class ImageSliderViewPagerAdapter :
    RecyclerView.Adapter<ImageSliderViewPagerHolder>() {

    private var _images: List<Int> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderViewPagerHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ItemImageSliderBinding.inflate(layoutInflater, parent, false)
        return ImageSliderViewPagerHolder(binding)
    }

    fun setImages(images: List<Int>) {
        _images = images
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = _images.size

    override fun onBindViewHolder(holder: ImageSliderViewPagerHolder, position: Int) {
        val product = _images[position]
        holder.bind(product)
    }

}