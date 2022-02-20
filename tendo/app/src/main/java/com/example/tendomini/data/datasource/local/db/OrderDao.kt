package com.example.tendomini.data.datasource.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tendomini.data.datasource.local.entites.OrderEntity

@Dao
interface OrderDao {

    @Insert()
    suspend fun addOrder(Order: OrderEntity): Long

    @Query("SELECT * FROM ORDERS WHERE id = :OrderId")
    fun getOrder(OrderId: Int): OrderEntity

    @get:Query("SELECT * FROM ORDERS")
    val getOrders: List<OrderEntity>

    @Query("DELETE FROM ORDERS")
    suspend fun deleteAll()
}