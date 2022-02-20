package com.example.tendomini.ui.order.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.tendomini.databinding.FragmentOrderDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderDetailFragment : Fragment() {

    private val args: OrderDetailFragmentArgs by navArgs()

    private val viewModel: OrderDetailViewModel by viewModels()

    private var _binding: FragmentOrderDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.setOrder(args.order)

        binding.buttonOrderDetailTrackOrder.setOnClickListener {

            val code = viewModel.orderCode.value.toString()
            val text = "I want to track order with code - $code"

            sendWhatsAppMsg("233240687954", text)
        }

    }

    private fun sendWhatsAppMsg(phoneNumber: String, text: String) {

        val textFmt = text.replace(" ", "%20")

        val whatsappUrl = String.format(
            "https://api.whatsapp.com/send?phone=%s&text=%s",
            phoneNumber,
            textFmt
        )

        val uri = Uri.parse(whatsappUrl)

        val intent = Intent(Intent.ACTION_VIEW, uri)

        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}