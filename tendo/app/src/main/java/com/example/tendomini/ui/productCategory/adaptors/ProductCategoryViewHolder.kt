package com.example.tendomini.ui.productCategory.adaptors

import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.R
import com.example.tendomini.data.datasource.local.entites.ProductCategoryEntity
import com.example.tendomini.databinding.ListItemProductCategoryBinding
import com.example.tendomini.domain.models.ProductCategory
import com.example.tendomini.internal.glide.GlideApp

class ProductCategoryViewHolder(
    private val binding: ListItemProductCategoryBinding,
    onProductCategoryClick: (ProductCategory) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var _category: ProductCategory

    fun bind(category: ProductCategory) {
        _category = category

        with(binding) {
            this.category = _category
            GlideApp.with(itemView.context).load(_category.image)
                .placeholder(R.drawable.tendo).into(imageProductCategory)
        }

    }

    init {
        itemView.setOnClickListener {
            onProductCategoryClick(_category)
        }
    }
}