package com.example.tendomini.data.datasource.productCategory

import com.example.tendomini.R
import com.example.tendomini.data.models.ProductCategory
import com.example.tendomini.data.models.Result

class ProductCategoryDataSourceImpl :
    ProductCategoryDataSource {
    val list = arrayListOf(
        ProductCategory(
            id = 1,
            name = "Phones",
            description = "",
            image = R.drawable.ic_twotone_smartphone_24
        ),
        ProductCategory(
            id = 2,
            name = "Beauty",
            description = "",
            image = R.drawable.ic_twotone_smartphone_24
        ),
        ProductCategory(
            id = 3,
            name = "Home",
            description = "",
            image = R.drawable.ic_twotone_house_24
        ),
        ProductCategory(
            id = 4,
            name = "Electronics",
            description = "",
            image = R.drawable.ic_twotone_live_tv_24
        ),
        ProductCategory(
            id = 5,
            name = "Computing",
            description = "",
            image = R.drawable.ic_twotone_devices_24
        ),
        ProductCategory(
            id = 6,
            name = "Fashion",
            description = "",
            image = R.drawable.ic_twotone_family_restroom_24
        ),
        ProductCategory(
            id = 7,
            name = "Sports",
            description = "",
            image = R.drawable.ic_twotone_sports_24
        ),

        )
    override val productCategories: Result<ArrayList<ProductCategory>>
        get() = Result.Success(list)

}