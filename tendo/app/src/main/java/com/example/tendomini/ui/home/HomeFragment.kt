package com.example.tendomini.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.tendomini.R
import com.example.tendomini.databinding.FragmentHomeBinding
import com.example.tendomini.domain.models.Product
import com.example.tendomini.domain.models.ProductCategory
import com.example.tendomini.ui.login.AuthenticationState
import com.example.tendomini.ui.product.adapters.ProductListAdapter
import com.example.tendomini.ui.productCategory.adaptors.ProductCategoryListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = NavHostFragment.findNavController(this)

        viewModel.authenticationState.observe(
            viewLifecycleOwner
        ) { authenticationState ->
            when (authenticationState) {
//                AuthenticationState.AUTHENTICATED -> showWelcomeMessage()
                AuthenticationState.UNAUTHENTICATED -> navController.navigate(R.id.loginFragment)
            }
        }

        getProducts()
        getProductCategories()

    }


    private fun getProducts() {
        viewModel.getProducts()
        if (view != null) {

            viewModel.productsResult.observe(viewLifecycleOwner,
                Observer { productsResult ->
                    productsResult ?: return@Observer
                    binding.progressBarHomeProductList.visibility = View.GONE
                    productsResult.error?.let {
//                        setupRecyclerProduct(it)
                    }
                    productsResult.success?.let {
                        setupRecyclerProduct(it as ArrayList<Product>)
                    }
                })

        }
    }

    private fun getProductCategories() {
        viewModel.getProductCategories()
        if (view != null) {

            viewModel.productCategoriesResult.observe(viewLifecycleOwner,
                Observer { productCategoriesResult ->
                    productCategoriesResult ?: return@Observer
                    binding.progressBarHomeProductCategoryList.visibility = View.GONE
                    productCategoriesResult.error?.let {
//                        setupRecyclerProduct(it)
                    }
                    productCategoriesResult.success?.let {
                        setupRecyclerProductCategory(it as ArrayList<ProductCategory>)
                    }
                })

        }
    }

    private fun setupRecyclerProductCategory(products: ArrayList<ProductCategory>) {
        val recyclerAdapter = ProductCategoryListAdapter(
            ::onCategoryClick,
        )
        binding.homeListProductCategory.adapter = recyclerAdapter
        recyclerAdapter.setProductCategories(products)
    }

    private fun onCategoryClick(category: ProductCategory) {
        val action =
            HomeFragmentDirections
                .actionNavigationHomeToProductFragment(
                    category.id
                )

        findNavController().navigate(action)
    }

    private fun setupRecyclerProduct(products: ArrayList<Product>) {
        val recyclerAdapter = ProductListAdapter(
            ::onProductClick,
        )
        binding.homeListProduct.adapter = recyclerAdapter
        recyclerAdapter.setProducts(products)
    }

    private fun onProductClick(product: Product) {
        val action =
            HomeFragmentDirections
                .actionNavigationHomeToProductDetailFragment(
                    product
                )

        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}