package com.example.tendomini.ui.product.detail

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.tendomini.R
import com.example.tendomini.databinding.DialogProductShareBinding
import com.example.tendomini.databinding.FragmentProductDetailBinding
import com.example.tendomini.internal.glide.GlideApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    private val viewModel: ProductDetailViewModel by viewModels()

    private val args: ProductDetailFragmentArgs by navArgs()

    private var _binding: FragmentProductDetailBinding? = null
    private var _dialogProductShareBinding: DialogProductShareBinding? = null

    private val binding get() = _binding!!
    private val dialogProductShareBinding get() = _dialogProductShareBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.setProduct(args.product)


        viewModel.product.observe(viewLifecycleOwner, Observer {
            setupViewPager(it.images)
        })

        binding.cardProductDetailAvailability.setOnClickListener {

            val product = viewModel.productName.value.toString()
            val text = "I want to check the availability of the product - $product"

            sendWhatsAppMsg("233240687954", text)
        }

        binding.imageProductDetailShare.setOnClickListener {

            showShareDialog()

        }

        binding.buttonProductDetailAddToCart.setOnClickListener {
            viewModel.addCartItem()
            val appContext = context?.applicationContext
            Toast.makeText(appContext, "Product Added to Cart", Toast.LENGTH_LONG).show()
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

    private fun setupViewPager(images: List<Int>) {
        val viewPagerAdapter = ImageSliderViewPagerAdapter()
        binding.viewPagerProductDetail.adapter = viewPagerAdapter
        viewPagerAdapter.setImages(images)

        lifecycleScope.launchWhenCreated {
            while (true) {
                for (i in 0..images.size) {
                    delay(1500)
                    if (i == 0) {
                        binding.viewPagerProductDetail.setCurrentItem(i, false)
                    } else {
                        binding.viewPagerProductDetail.setCurrentItem(i, true)
                    }
                }
            }
        }
    }

    private fun showShareDialog() {

        _dialogProductShareBinding =
            DialogProductShareBinding.inflate(LayoutInflater.from(context))

        dialogProductShareBinding.viewModel = viewModel
        dialogProductShareBinding.lifecycleOwner = viewLifecycleOwner

        val builder = AlertDialog.Builder(requireContext())
            .setView(dialogProductShareBinding.root)
//            .setTitle("CONFIGURATIONS")

//        val mAlertDialog: AlertDialog = builder.show()

        val appContext = context?.applicationContext ?: return

        val pdtImage = viewModel.product.value!!.images[0]
        GlideApp.with(appContext).load(pdtImage)
            .placeholder(R.drawable.tendo).into(dialogProductShareBinding.imageDlgShareProductImage)


        dialogProductShareBinding.buttonDlgShare.setOnClickListener {

            val name = viewModel.productName.value!!.toString()
            val price = viewModel.productPriceEdt.value!!.toString()

            val path = MediaStore.Images.Media.insertImage(
                requireContext().contentResolver,
                BitmapFactory.decodeResource(resources, pdtImage), null, null
            )

            val imageUri = Uri.parse(path)

            val intent = Intent()
            intent.action = Intent.ACTION_SEND

            intent.putExtra(Intent.EXTRA_STREAM, imageUri)
            intent.putExtra(Intent.EXTRA_TEXT, "$name \n $price")

            intent.type = "*/*"

            startActivity(Intent.createChooser(intent, "Share to : "))

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}