package com.example.tendomini.ui.order.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.databinding.ListItemOrderBinding
import com.example.tendomini.domain.models.Order
import java.util.*

class OrderListAdapter(private val onOrderClick: (Order) -> Unit) :
    RecyclerView.Adapter<OrderViewHolder>(), Filterable {

    private var _orders: ArrayList<Order> = arrayListOf()
    var orderFilter: ArrayList<Order> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemOrderBinding.inflate(layoutInflater, parent, false)
        return OrderViewHolder(binding, onOrderClick)
    }

    fun setOrders(orders: ArrayList<Order>) {
        _orders = orders
        orderFilter = orders
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = orderFilter.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orderFilter[position]
        holder.bind(order)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                orderFilter = if (charSearch.isEmpty()) {
                    _orders
                } else {
                    val resultList: ArrayList<Order> = arrayListOf()
                    for (order in _orders) {

                        if ((order.code.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT)))
                        ) {
                            resultList.add(order)
                        }


                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = orderFilter
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                orderFilter = results?.values as ArrayList<Order>

                notifyDataSetChanged()
            }

        }
    }
}