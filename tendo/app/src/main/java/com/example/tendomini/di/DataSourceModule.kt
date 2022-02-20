package com.example.tendomini.di

import com.example.tendomini.data.datasource.local.order.OrderDataSource
import com.example.tendomini.data.datasource.local.order.OrderDataSourceImpl
import com.example.tendomini.data.datasource.remote.deliveryLocation.DeliveryLocationDataSource
import com.example.tendomini.data.datasource.remote.deliveryLocation.DeliveryLocationDataSourceImpl
import com.example.tendomini.data.datasource.remote.paymentMethod.PaymentMethodDataSource
import com.example.tendomini.data.datasource.remote.paymentMethod.PaymentMethodDataSourceImpl
import com.example.tendomini.data.datasource.remote.product.ProductDataSource
import com.example.tendomini.data.datasource.remote.product.ProductDataSourceImpl
import com.example.tendomini.data.datasource.remote.productCategory.ProductCategoryDataSource
import com.example.tendomini.data.datasource.remote.productCategory.ProductCategoryDataSourceImpl
import com.example.tendomini.data.datasource.remote.user.UserDataSource
import com.example.tendomini.data.datasource.remote.user.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceLocalModule {

    @Singleton
    @Binds
    abstract fun bindOrderDataSource(impl: OrderDataSourceImpl): OrderDataSource

}

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceRemoteModule {


    @Singleton
    @Binds
    abstract fun bindUserDataSource(impl: UserDataSourceImpl): UserDataSource

    @Singleton
    @Binds
    abstract fun bindProductDataSource(impl: ProductDataSourceImpl): ProductDataSource

    @Singleton
    @Binds
    abstract fun bindProductCategoryDataSource(impl: ProductCategoryDataSourceImpl): ProductCategoryDataSource

    @Singleton
    @Binds
    abstract fun bindPaymentMethodDataSource(impl: PaymentMethodDataSourceImpl): PaymentMethodDataSource

    @Singleton
    @Binds
    abstract fun bindDeliveryLocationDataSource(impl: DeliveryLocationDataSourceImpl): DeliveryLocationDataSource

}
