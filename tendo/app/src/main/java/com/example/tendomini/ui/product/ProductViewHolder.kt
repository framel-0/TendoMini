package com.example.tendomini.ui.product

import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.R
import com.example.tendomini.data.models.Product
import com.example.tendomini.databinding.ListItemProductBinding
import com.example.tendomini.internal.glide.GlideApp

class ProductViewHolder(
    private val binding: ListItemProductBinding,
    onProductClick: (Product) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var _product: Product

    fun bind(product: Product, position: Int) {
        _product = product

        with(binding) {
            this.product = _product
            GlideApp.with(itemView.context).load(_product.images[0])
                .placeholder(R.drawable.tendo).into(imageProductName)
        }

    }

    init {
        itemView.setOnClickListener {
            onProductClick(_product)
        }
    }
}