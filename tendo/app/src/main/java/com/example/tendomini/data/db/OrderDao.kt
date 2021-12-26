package com.example.tendomini.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tendomini.data.models.Order

@Dao
interface OrderDao {
    @Insert()
    fun addOrder(Order: Order): Long

    @Query("SELECT * FROM order_items WHERE id = :OrderId")
    fun getOrder(OrderId: Int): Order

    @get:Query("SELECT * FROM order_items")
    val getOrders: List<Order>

    @Query("DELETE FROM order_items")
    fun deleteAll()
}