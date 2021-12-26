package com.example.tendomini.ui.product.detail

import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.R
import com.example.tendomini.databinding.ItemImageSliderBinding
import com.example.tendomini.internal.glide.GlideApp

class ImageSliderViewPagerHolder(
    private val binding: ItemImageSliderBinding,
) :
    RecyclerView.ViewHolder(binding.root) {

    private var _image: Int = 0

    fun bind(image: Int, position: Int) {
        _image = image
        with(binding) {
            GlideApp.with(itemView.context).load(_image)
                .placeholder(R.drawable.tendo).into(imageItmImgSlider)
        }

    }

}