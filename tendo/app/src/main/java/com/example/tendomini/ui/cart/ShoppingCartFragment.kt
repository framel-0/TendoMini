package com.example.tendomini.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.tendomini.databinding.FragmentShoppingCartBinding
import com.example.tendomini.domain.models.CartItem
import com.example.tendomini.domain.models.DeliveryLocation
import com.example.tendomini.ui.cart.adapters.ShoppingCartAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingCartFragment : Fragment() {

    private val viewModel: ShoppingCartViewModel by viewModels()

    private var _binding: FragmentShoppingCartBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.cartItems.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                binding.listShoppingCart.visibility = View.INVISIBLE
                binding.groupCart.visibility = View.VISIBLE
                binding.buttonCartNext.isEnabled = false
            } else {
                binding.listShoppingCart.visibility = View.VISIBLE
                binding.groupCart.visibility = View.INVISIBLE
                binding.buttonCartNext.isEnabled = true
            }
            val cartItems: List<CartItem> = ArrayList(it.asReversed())
            setupRecyclerCart(cartItems)
        })

        viewModel.cartItemCount.observe(viewLifecycleOwner, Observer {
            viewModel.itemCount.postValue(" $it ")
        })
        viewModel.cartTotalPrice.observe(viewLifecycleOwner, Observer {
            viewModel.totalPrice.postValue(String.format("GHC %,.2f ", it))
        })

        binding.buttonCartNext.setOnClickListener {
            val action =
                ShoppingCartFragmentDirections
                    .actionShoppingCartFragmentToOrderFragment(
                        viewModel.deliveryLocation.value!!,
                        viewModel.description.value.toString()
                    )

            findNavController().navigate(action)
        }

        getDeliveryLocations()

        return binding.root
    }

    private fun setupRecyclerCart(cartItems: List<CartItem>) {
        val recyclerAdapter = ShoppingCartAdapter(
            ::onSubClick,
            ::onAddClick,
            ::onDeleteClick
        )
        binding.listShoppingCart.adapter = recyclerAdapter
        recyclerAdapter.setCartItems(cartItems)
    }


    private fun onDeleteClick(itemPosition: CartItem) {
        viewModel.removeCartItem(itemPosition)
    }

    private fun onSubClick(itemPosition: CartItem) {
        viewModel.decreaseCartItemQuantity(itemPosition)
    }

    private fun onAddClick(itemPosition: CartItem) {
        viewModel.increaseCartItemQuantity(itemPosition)
    }

    private fun getDeliveryLocations() {
        viewModel.getDeliveryLocations()
//        if (view != null) {

        viewModel.deliveryLocationsResult.observe(viewLifecycleOwner,
            Observer { deliveryLocationsResult ->
                deliveryLocationsResult ?: return@Observer
//                    binding.progressBarProductCategory.visibility = View.GONE
                deliveryLocationsResult.error?.let {
                }
                deliveryLocationsResult.success?.let {
                    setupSpinnerDeliveryLocation(it as ArrayList<DeliveryLocation>)
                }
            })

//        }
    }

    private fun setupSpinnerDeliveryLocation(locations: ArrayList<DeliveryLocation>) {
        val adapterDeliveryLocation: ArrayAdapter<DeliveryLocation> =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                locations
            )

        binding.spinnerCartDeliveryLocation.adapter =
            adapterDeliveryLocation

        binding.spinnerCartDeliveryLocation.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // You can define you actions as you want
                }

                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    val location =
                        binding.spinnerCartDeliveryLocation.selectedItem as DeliveryLocation

                    viewModel.setDeliveryLocation(location)

                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}