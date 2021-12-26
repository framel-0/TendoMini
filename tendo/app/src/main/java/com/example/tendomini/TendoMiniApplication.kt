package com.example.tendomini

import android.app.Application
import com.example.tendomini.data.datasource.deliveryLocation.*
import com.example.tendomini.data.datasource.order.*
import com.example.tendomini.data.datasource.paymentMethod.*
import com.example.tendomini.data.datasource.product.*
import com.example.tendomini.data.datasource.productCategory.*
import com.example.tendomini.data.datasource.user.*
import com.example.tendomini.data.db.*
import com.example.tendomini.data.repository.deliveryLocation.*
import com.example.tendomini.data.repository.order.*
import com.example.tendomini.data.repository.paymentMethod.*
import com.example.tendomini.data.repository.product.*
import com.example.tendomini.data.repository.productCategory.*
import com.example.tendomini.data.repository.user.*
import com.example.tendomini.ui.SharedViewModelFactory
import com.example.tendomini.ui.cart.ShoppingCartViewModelFactory
import com.example.tendomini.ui.home.HomeViewModelFactory
import com.example.tendomini.ui.login.LoginViewModelFactory
import com.example.tendomini.ui.order.OrderViewModelFactory
import com.example.tendomini.ui.orderSummary.OrderSummaryViewModelFactory
import com.example.tendomini.ui.product.ProductViewModelFactory
import com.example.tendomini.ui.productCategory.ProductCategoryViewModelFactory
import com.example.tendomini.ui.register.RegisterViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*

class TendoMiniApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {

        import(androidXModule(this@TendoMiniApplication))

        bind() from singleton { ApplicationDatabase(instance()) }
        bind() from singleton { instance<ApplicationDatabase>().userDao() }
        bind() from singleton { instance<ApplicationDatabase>().orderDao() }

        bind<UserDataSource>() with singleton {
            UserDataSourceImpl(
            )
        }

        bind<ProductDataSource>() with singleton {
            ProductDataSourceImpl(
            )
        }

        bind<ProductCategoryDataSource>() with singleton {
            ProductCategoryDataSourceImpl(
            )
        }

        bind<PaymentMethodDataSource>() with singleton {
            PaymentMethodDataSourceImpl(
            )
        }

        bind<DeliveryLocationDataSource>() with singleton {
            DeliveryLocationDataSourceImpl(
            )
        }

        bind<OrderDataSource>() with singleton {
            OrderDataSourceImpl(
                instance()
            )
        }


        bind<UserRepository>() with singleton {
            UserRepositoryImpl(
                instance()
            )
        }

        bind<ProductRepository>() with singleton {
            ProductRepositoryImpl(
                instance()
            )
        }

        bind<ProductCategoryRepository>() with singleton {
            ProductCategoryRepositoryImpl(
                instance()
            )
        }

        bind<PaymentMethodRepository>() with singleton {
            PaymentMethodRepositoryImpl(
                instance()
            )
        }

        bind<DeliveryLocationRepository>() with singleton {
            DeliveryLocationRepositoryImpl(
                instance()
            )
        }

        bind<OrderRepository>() with singleton {
            OrderRepositoryImpl(
                instance()
            )
        }



        bind() from provider { SharedViewModelFactory(instance()) }
        bind() from provider { LoginViewModelFactory(instance()) }
        bind() from provider { RegisterViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance(), instance(), instance()) }
        bind() from provider { ProductViewModelFactory(instance()) }
        bind() from provider { ProductCategoryViewModelFactory(instance()) }
        bind() from provider { ShoppingCartViewModelFactory(instance()) }
        bind() from provider { OrderViewModelFactory(instance()) }
        bind() from provider { OrderSummaryViewModelFactory(instance()) }
    }

}