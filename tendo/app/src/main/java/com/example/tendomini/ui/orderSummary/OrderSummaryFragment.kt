package com.example.tendomini.ui.orderSummary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.tendomini.R
import com.example.tendomini.databinding.FragmentOrderSummaryBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class OrderSummaryFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    private lateinit var viewModel: OrderSummaryViewModel
    private val summaryViewModelFactory: OrderSummaryViewModelFactory by instance()

    private val args: OrderSummaryFragmentArgs by navArgs()

    private var _binding: FragmentOrderSummaryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderSummaryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this, summaryViewModelFactory).get(OrderSummaryViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.setDeliveryLocation(args.deliveryLocation)
        viewModel.setDescription(args.description)

        viewModel.cartItemCount.observe(viewLifecycleOwner, Observer {
            viewModel.itemCount.postValue(" Items $it ")
        })

        viewModel.cartTotalPrice.observe(viewLifecycleOwner, Observer {
            viewModel.itemsCost.postValue(String.format("GHC %,.2f ", it))
            val location = viewModel.deliveryLocation.value

            if (location != null) {
                val tCost = location.price + it
                viewModel.totalCost.postValue(String.format("GHC %,.2f ", tCost))
            }

        })

        viewModel.deliveryLocation.observe(viewLifecycleOwner, Observer {
            viewModel.deliveryCost.postValue(String.format("GHC %,.2f ", it.price))

            val itsCost = viewModel.cartTotalPrice.value!!
            val tCost = itsCost + it.price
            viewModel.totalCost.postValue(String.format("GHC %,.2f ", tCost))

        })

        binding.buttonOrderSubmit.setOnClickListener {
            binding.progressBarOrderSummary.visibility = View.VISIBLE
            viewModel.saveOrder()

        }

        viewModel.orderResult.observe(viewLifecycleOwner,
            Observer { OrderResult ->
                OrderResult ?: return@Observer
                binding.progressBarOrderSummary.visibility = View.GONE
                OrderResult.error?.let {
                }
                OrderResult.success?.let {
                    val appContext = context?.applicationContext
                    Toast.makeText(appContext, "Order Saved", Toast.LENGTH_LONG).show()

                    viewModel.clearCart()

                    val navController = NavHostFragment.findNavController(this)
                    navController.navigate(R.id.navigation_home)
                }
            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}