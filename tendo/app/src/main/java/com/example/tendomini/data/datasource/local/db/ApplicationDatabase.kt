package com.example.tendomini.data.datasource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tendomini.data.datasource.local.entites.*
import com.example.tendomini.data.datasource.local.utils.DateTypeConverter
import com.example.tendomini.data.datasource.local.utils.ImageConverters
import com.example.tendomini.data.datasource.local.utils.ItemConverters

@Database(
    entities = [UserEntity::class, OrderEntity::class, CartItemEntity::class, ProductEntity::class],
    version = 1
)
@TypeConverters(DateTypeConverter::class, ItemConverters::class, ImageConverters::class)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun orderDao(): OrderDao

    companion object {
        private var instance: ApplicationDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ApplicationDatabase::class.java, "application.db"
            ).addTypeConverter(ItemConverters::class.java).build()
    }
}