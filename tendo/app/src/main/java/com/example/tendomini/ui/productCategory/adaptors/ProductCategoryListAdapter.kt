package com.example.tendomini.ui.productCategory.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.tendomini.databinding.ListItemProductCategoryBinding
import com.example.tendomini.domain.models.ProductCategory
import java.util.*

class ProductCategoryListAdapter(private val onProductCategoryClick: (ProductCategory) -> Unit) :
    RecyclerView.Adapter<ProductCategoryViewHolder>(), Filterable {

    private var _categories: ArrayList<ProductCategory> = arrayListOf()
    var categoryFilter: ArrayList<ProductCategory> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemProductCategoryBinding.inflate(layoutInflater, parent, false)
        return ProductCategoryViewHolder(binding, onProductCategoryClick)
    }

    fun setProductCategories(categories: ArrayList<ProductCategory>) {
        _categories = categories
        categoryFilter = categories
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = categoryFilter.size

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        val category = categoryFilter[position]
        holder.bind(category)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                categoryFilter = if (charSearch.isEmpty()) {
                    _categories
                } else {
                    val resultList: ArrayList<ProductCategory> = arrayListOf()
                    for (category in _categories) {


                        if ((category.name.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT)))
                        ) {
                            resultList.add(category)
                        }

                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = categoryFilter
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                categoryFilter = results?.values as ArrayList<ProductCategory>

                notifyDataSetChanged()
            }

        }
    }
}