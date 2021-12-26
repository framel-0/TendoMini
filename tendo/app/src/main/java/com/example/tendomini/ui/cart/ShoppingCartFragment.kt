package com.example.tendomini.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tendomini.data.models.CartItem
import com.example.tendomini.data.models.DeliveryLocation
import com.example.tendomini.databinding.FragmentShoppingCartBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class ShoppingCartFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    private lateinit var viewModel: ShoppingCartViewModel
    private val viewModelFactory: ShoppingCartViewModelFactory by instance()

    private var _binding: FragmentShoppingCartBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoppingCartViewModel::class.java)
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

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
                        deliveryLocation = viewModel.deliveryLocation.value!!,
                        description = viewModel.description.value.toString()
                    )

            findNavController().navigate(action)
        }

        getDeliveryLocations()

        return root
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
                        setupSpinnerDeliveryLocation(it)
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