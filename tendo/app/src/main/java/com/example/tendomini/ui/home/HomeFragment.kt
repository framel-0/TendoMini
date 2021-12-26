package com.example.tendomini.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.tendomini.R
import com.example.tendomini.data.models.Product
import com.example.tendomini.data.models.ProductCategory
import com.example.tendomini.databinding.FragmentHomeBinding
import com.example.tendomini.ui.login.AuthenticationState
import com.example.tendomini.ui.product.ProductListAdapter
import com.example.tendomini.ui.productCategory.ProductCategoryListAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class HomeFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    private lateinit var viewModel: HomeViewModel
    private val viewModelFactory: HomeViewModelFactory by instance()

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        val navController = NavHostFragment.findNavController(this)

        viewModel.authenticationState.observe(
            viewLifecycleOwner,
            Observer { authenticationState ->
                when (authenticationState) {
//                AuthenticationState.AUTHENTICATED -> showWelcomeMessage()
                    AuthenticationState.UNAUTHENTICATED ->  navController.navigate(R.id.loginFragment)
                }
            })

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
                        setupRecyclerProduct(it)
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
                        setupRecyclerProductCategory(it)
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
                    categoryId = category.id
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
                    product = product
                )

        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}