package com.example.tendomini.data.datasource.remote.productCategory

import com.example.tendomini.R
import com.example.tendomini.data.datasource.remote.dtos.ProductCategoryDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductCategoryDataSourceImpl @Inject constructor() :
    ProductCategoryDataSource {
    val list = arrayListOf(
        ProductCategoryDto(
            id = 1,
            name = "Phones",
            description = "",
            image = R.drawable.ic_twotone_smartphone_24
        ),
        ProductCategoryDto(
            id = 2,
            name = "Beauty",
            description = "",
            image = R.drawable.ic_twotone_supervised_user_circle_24
        ),
        ProductCategoryDto(
            id = 3,
            name = "Home",
            description = "",
            image = R.drawable.ic_twotone_house_24
        ),
        ProductCategoryDto(
            id = 4,
            name = "Electronics",
            description = "",
            image = R.drawable.ic_twotone_live_tv_24
        ),
        ProductCategoryDto(
            id = 5,
            name = "Computing",
            description = "",
            image = R.drawable.ic_twotone_devices_24
        ),
        ProductCategoryDto(
            id = 6,
            name = "Fashion",
            description = "",
            image = R.drawable.ic_twotone_family_restroom_24
        ),
        ProductCategoryDto(
            id = 7,
            name = "Sports",
            description = "",
            image = R.drawable.ic_twotone_sports_24
        ),

        )
    override val productCategories: ArrayList<ProductCategoryDto>
        get() = (list)

}