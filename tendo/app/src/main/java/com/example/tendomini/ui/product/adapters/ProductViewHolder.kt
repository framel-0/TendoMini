package com.example.tendomini.ui.product.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.R
import com.example.tendomini.data.datasource.local.entites.ProductEntity
import com.example.tendomini.databinding.ListItemProductBinding
import com.example.tendomini.domain.models.Product
import com.example.tendomini.internal.glide.GlideApp

class ProductViewHolder(
    private val binding: ListItemProductBinding,
    onProductClick: (Product) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var _product: Product

    fun bind(product: Product) {
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