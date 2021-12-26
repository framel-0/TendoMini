package com.example.tendomini.ui.order

import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.data.models.Order
import com.example.tendomini.databinding.ListItemOrderBinding

class OrderViewHolder(
    private val binding: ListItemOrderBinding,
    onOrderClick: (Order) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var _order: Order

    fun bind(order: Order, position: Int) {
        _order = order

        with(binding) {
            this.order = _order
        }

    }

    init {
        itemView.setOnClickListener {
            onOrderClick(_order)
        }
    }
}