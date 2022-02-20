package com.example.tendomini.ui.product

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tendomini.databinding.FragmentProductBinding
import com.example.tendomini.domain.models.Product
import com.example.tendomini.ui.product.adapters.ProductListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()

    private val args: ProductFragmentArgs by navArgs()

    private var _binding: FragmentProductBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getProducts(args.categoryId)
    }

    private fun setupSearchView(listAdapter: ProductListAdapter) {
        binding.searchProduct.setOnQueryTextListener(object :
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

    private fun getProducts(categoryId: Int) {
        viewModel.getProducts(categoryId)
        if (view != null) {

            viewModel.productsResult.observe(viewLifecycleOwner,
                Observer { productsResult ->
                    productsResult ?: return@Observer
                    binding.progressBarProduct.visibility = View.GONE
                    productsResult.error?.let {
//                        setupRecyclerProduct(it)
                    }
                    productsResult.success?.let {
                        setupRecyclerProduct(it as ArrayList<Product>)
                    }
                })

        }
    }

    private fun setupRecyclerProduct(products: ArrayList<Product>) {
        val recyclerAdapter = ProductListAdapter(
            ::onProductClick,
        )
        binding.listProduct.adapter = recyclerAdapter
        recyclerAdapter.setProducts(products)
        setupSearchView(recyclerAdapter)
    }

    private fun onProductClick(product: Product) {
        val action =
            ProductFragmentDirections
                .actionProductFragmentToProductDetailFragment(
                    product
                )

        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}