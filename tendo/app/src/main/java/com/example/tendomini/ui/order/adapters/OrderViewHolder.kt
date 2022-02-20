package com.example.tendomini.ui.order.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.databinding.ListItemOrderBinding
import com.example.tendomini.domain.models.Order

class OrderViewHolder(
    private val binding: ListItemOrderBinding,
    onOrderClick: (Order) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var _order: Order

    fun bind(order: Order) {
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