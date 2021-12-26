package com.example.tendomini.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.data.models.CartItem
import com.example.tendomini.databinding.ListItemCartBinding

class ShoppingCartAdapter(
    private val onSubClick: (CartItem) -> Unit,
    private val onAddClick: (CartItem) -> Unit,
    private val onDeleteClick: (CartItem) -> Unit
) : RecyclerView.Adapter<ShoppingCartViewHolder>() {

    private var _cartItems: List<CartItem> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemCartBinding.inflate(layoutInflater, parent, false)

        return ShoppingCartViewHolder(
            binding,
            onSubClick,
            onAddClick,
            onDeleteClick
        )
    }

    fun setCartItems(cartItems: List<CartItem>) {
        _cartItems = cartItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = _cartItems.size

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        val cartItem = _cartItems[position]

        holder.bind(cartItem, position)

    }
}