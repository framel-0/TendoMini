package com.example.tendomini.ui.productCategory

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tendomini.data.models.ProductCategory
import com.example.tendomini.databinding.FragmentProductCategoryBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class ProductCategoryFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    private lateinit var viewModel: ProductCategoryViewModel
    private val viewModelFactory:  ProductCategoryViewModelFactory by instance()

    private var _binding: FragmentProductCategoryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProductCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(ProductCategoryViewModel::class.java)

        getProductCategories()
    }

    private fun setupSearchView(listAdapter: ProductCategoryListAdapter) {
        binding.searchProductCategory.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                hideKeyboard()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listAdapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun Fragment.hideKeyboard() {
        view?.let {
            activity?.hideKeyboard(it)
        }
    }

    private fun getProductCategories() {
        viewModel.getProductCategories()
        if (view != null) {

            viewModel.productCategoriesResult.observe(viewLifecycleOwner,
                Observer { productCategoriesResult ->
                    productCategoriesResult ?: return@Observer
                    binding.progressBarProductCategory.visibility = View.GONE
                    productCategoriesResult.error?.let {
//                        setupRecyclerProduct(it)
                    }
                    productCategoriesResult.success?.let {
                        setupRecyclerProductCategory(it)
                    }
                })

        }
    }

    private fun setupRecyclerProductCategory(products: ArrayList<ProductCategory>) {
        val recyclerAdapter = ProductCategoryListAdapter(
            ::onCategoryClick,
        )
        binding.listProductCategory.adapter = recyclerAdapter
        recyclerAdapter.setProductCategories(products)

        setupSearchView(recyclerAdapter)
    }

    private fun onCategoryClick(category: ProductCategory) {
        val action =
            ProductCategoryFragmentDirections
                .actionNavigationProductCategoryToProductFragment(
                    categoryId = category.id
                )

        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}