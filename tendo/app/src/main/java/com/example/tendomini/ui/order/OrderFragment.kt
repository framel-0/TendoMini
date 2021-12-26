package com.example.tendomini.ui.order

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
import com.example.tendomini.data.models.Order
import com.example.tendomini.databinding.FragmentOrderBinding
import com.example.tendomini.ui.product.ProductFragmentDirections
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class OrderFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    private lateinit var viewModel: OrderViewModel
    private val viewModelFactory: OrderViewModelFactory by instance()

    private var _binding: FragmentOrderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(OrderViewModel::class.java)

        getOrders()

    }

    private fun setupSearchView(listAdapter: OrderListAdapter) {
        binding.searchOrder.setOnQueryTextListener(object :
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

    private fun getOrders() {
        viewModel.getOrders()
        if (view != null) {

            viewModel.ordersResult.observe(viewLifecycleOwner,
                Observer { ordersResult ->
                    ordersResult ?: return@Observer
                    binding.progressBarOrder.visibility = View.GONE
                    ordersResult.error?.let {
//                        setupRecyclerOrder(it)
                    }
                    ordersResult.success?.let {
                        setupRecyclerOrder(it)
                    }
                })

        }
    }

    private fun setupRecyclerOrder(orders: ArrayList<Order>) {
        val recyclerAdapter = OrderListAdapter(
            ::onOrderClick,
        )
        binding.listOrders.adapter = recyclerAdapter
        recyclerAdapter.setOrders(orders)
        setupSearchView(recyclerAdapter)
    }

    private fun onOrderClick(order: Order) {
        val action =
            OrderFragmentDirections
                .actionOrderFragmentToOrderDetailFragment(
                    order = order
                )

        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}