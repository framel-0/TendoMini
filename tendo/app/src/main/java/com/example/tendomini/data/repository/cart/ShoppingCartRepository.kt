package com.example.tendomini.data.repository.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tendomini.data.models.CartItem
import io.paperdb.Paper

object ShoppingCartRepository {

    private const val CART: String = "cart"

    private val _emptyCartItems = MutableLiveData<MutableList<CartItem>>()
    val emptyCartItems: LiveData<MutableList<CartItem>>
        get() = _emptyCartItems

    private val _cartItems = MutableLiveData<MutableList<CartItem>>()
    val cartItems: LiveData<MutableList<CartItem>>
        get() = _cartItems

    private val _totalPrice = MutableLiveData<Double>()
    val totalPrice: LiveData<Double>
        get() = _totalPrice


    val totalCartPrice: Double
        get() = getCartPrice()


    private val _totalQuantity = MutableLiveData<Int>()

    val totalQuantity: LiveData<Int>
        get() = _totalQuantity

    init {
        setCartItems()

        setTotalPrice()

        _totalQuantity.postValue(getCartQuantity())
    }


    private fun setCartItems() {
        _cartItems.value = getCart()
    }

    fun postCartItems() {
        _cartItems.postValue(getCart())
    }

    private fun setTotalPrice() {
//        _totalPrice.postValue(getCartPrice())
        _totalPrice.value = getCartPrice()
    }

    fun postTotalPrice() {
        _totalPrice.postValue(getCartPrice())
    }

    fun addCartItem(cartItem: CartItem) {
        val cart =
            getCart()

        val targetItem = cart.singleOrNull { it.product.id == cartItem.product.id }
        if (targetItem == null) {
            cart.add(cartItem)
        } else {
            targetItem.quantity++
        }

        saveCart(
            cart
        )
        setCartItems()
        setTotalPrice()
    }

    fun removeCartItem(cartItem: CartItem) {
        val cart =
            getCart()
        val targetItem = cart.singleOrNull { it.product.id == cartItem.product.id }
//        val cartItem = cart[cartItem]

        cart.remove(targetItem)

        saveCart(
            cart
        )

        setCartItems()
        setTotalPrice()
    }


    fun increaseCartItemQuantity(cartItem: CartItem) {
        val cart =
            getCart()

        val targetItem = cart.singleOrNull { it.product.id == cartItem.product.id }
        if (targetItem != null) {
            targetItem.quantity++
        }
        saveCart(
            cart
        )

        setCartItems()
        setTotalPrice()

    }


    fun decreaseCartItemQuantity(cartItem: CartItem) {
        val cart =
            getCart()
        val targetItem = cart.singleOrNull { it.product.id == cartItem.product.id }
        if (targetItem != null) {
            if (targetItem.quantity > 1) {
                targetItem.quantity--
            }
        }

        saveCart(
            cart
        )

        setCartItems()
        setTotalPrice()

    }


    fun removeALLCartItem() {
        deleteCart()
        setCartItems()
        setTotalPrice()
    }

    private fun saveCart(cart: MutableList<CartItem>) {
        Paper.book().write(CART, cart)
    }


    fun getCart(): MutableList<CartItem> {
        return Paper.book().read(CART, mutableListOf())
    }


    fun deleteCart() = Paper.book().delete(CART)


    fun getShoppingCartSize(): Int {
        var cartSize = 0
        getCart()
            .forEach {
                cartSize += it.quantity
            }

        return cartSize
    }

    private fun getCartPrice(): Double {
        var price = 0.0
        _cartItems.value?.forEach {
            price += (it.product.price * it.quantity)
        }
        return price
    }


    private fun getCartQuantity(): Int {
        var quantity = 0
        _cartItems.value?.forEach {
            quantity += it.quantity
        }
        return quantity
    }


}