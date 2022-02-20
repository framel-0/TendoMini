package com.example.tendomini.di

import com.example.tendomini.data.repository.deliveryLocation.DeliveryLocationRepository
import com.example.tendomini.data.repository.deliveryLocation.DeliveryLocationRepositoryImpl
import com.example.tendomini.data.repository.order.OrderRepository
import com.example.tendomini.data.repository.order.OrderRepositoryImpl
import com.example.tendomini.data.repository.paymentMethod.PaymentMethodRepository
import com.example.tendomini.data.repository.paymentMethod.PaymentMethodRepositoryImpl
import com.example.tendomini.data.repository.product.ProductRepository
import com.example.tendomini.data.repository.product.ProductRepositoryImpl
import com.example.tendomini.data.repository.productCategory.ProductCategoryRepository
import com.example.tendomini.data.repository.productCategory.ProductCategoryRepositoryImpl
import com.example.tendomini.data.repository.user.UserRepository
import com.example.tendomini.data.repository.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository

    @Singleton
    @Binds
    abstract fun bindProductCategoryRepository(impl: ProductCategoryRepositoryImpl): ProductCategoryRepository

    @Singleton
    @Binds
    abstract fun bindPaymentMethodRepository(impl: PaymentMethodRepositoryImpl): PaymentMethodRepository

    @Singleton
    @Binds
    abstract fun bindDeliveryLocationRepository(impl: DeliveryLocationRepositoryImpl): DeliveryLocationRepository

    @Singleton
    @Binds
    abstract fun bindOrderRepository(impl: OrderRepositoryImpl): OrderRepository


}