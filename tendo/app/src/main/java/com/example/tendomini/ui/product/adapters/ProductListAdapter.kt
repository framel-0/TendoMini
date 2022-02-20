package com.example.tendomini.ui.product.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.databinding.ListItemProductBinding
import com.example.tendomini.domain.models.Product
import java.util.*

class ProductListAdapter(private val onProductClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductViewHolder>(), Filterable {

    private var _products: ArrayList<Product> = arrayListOf()
    var productFilter: ArrayList<Product> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemProductBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding, onProductClick)
    }

    fun setProducts(products: ArrayList<Product>) {
        _products = products
        productFilter = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = productFilter.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productFilter[position]
        holder.bind(product)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                productFilter = if (charSearch.isEmpty()) {
                    _products
                } else {
                    val resultList: ArrayList<Product> = arrayListOf()
                    for (product in _products) {

                        if ((product.name.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT)))
                        ) {
                            resultList.add(product)
                        }


                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = productFilter
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                productFilter = results?.values as ArrayList<Product>

                notifyDataSetChanged()
            }

        }
    }
}