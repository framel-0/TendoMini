package com.example.tendomini.ui.cart

import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.R
import com.example.tendomini.data.models.CartItem
import com.example.tendomini.databinding.ListItemCartBinding
import com.example.tendomini.internal.glide.GlideApp

class ShoppingCartViewHolder(
    private val binding: ListItemCartBinding,
    onSubClick: (CartItem) -> Unit,
    onAddClick: (CartItem) -> Unit,
    onDeleteClick: (CartItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var cartItemPosition: Int = 0
    private lateinit var _cartItem: CartItem

    fun bind(cartItem: CartItem, position: Int) {
        cartItemPosition = position
        _cartItem = cartItem
        with(binding) {
            this.cartItem = _cartItem
            GlideApp.with(itemView.context).load(cartItem.product.images[0])
                .placeholder(R.drawable.tendo).into(imageProduct)
        }
    }

    init {
        binding.imageItmCartButtonDelete.setOnClickListener {
            onDeleteClick(_cartItem)
        }
        binding.imageItmCartButtonSub.setOnClickListener {
            onSubClick(_cartItem)
        }
        binding.imageItmCartButtonAdd.setOnClickListener {
            onAddClick(_cartItem)
        }
    }


}