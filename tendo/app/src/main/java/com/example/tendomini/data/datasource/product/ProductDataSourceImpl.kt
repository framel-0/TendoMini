package com.example.tendomini.data.datasource.product

import com.example.tendomini.R
import com.example.tendomini.data.models.Product
import com.example.tendomini.data.models.Result

class ProductDataSourceImpl : ProductDataSource {

    val list = arrayListOf(
        Product(
            id = 1,
            name = "Tecno Spark Go 2021",
            description = "Tecno SPARK GO 2021 is beautifully manufactured  in China and can be slipped into your pocket or carried alone for all your calls, work bits and pieces. It is mostly made up of Plastic ,Glass, Silicon and Lead. Its battery is made up of Li-ion .This product is perfect for home and Office use.   ",
            price = 547.00,
            images = listOf(R.drawable.tecno_spark_go_1, R.drawable.tecno_spark_go_2),
            categoryId = 1
        ),
        Product(
            id = 2,
            name = "Itel S16 Dual SIM",
            description = "The S16 Series offer a smooth curved design that provides the slimmest smartphones from itel so far. The ultra-efficiency unibody design ensures a seamless one-hand operation for everyone.",
            price = 417.00,
            images = listOf(R.drawable.itel_s16),
            categoryId = 1,
        ),
        Product(
            id = 3,
            name = "Apple iPhone 6",
            description = "The all-new A8 chip in Apple iPhone 6 Smartphone is designed to be power efficient and the fastest yet. The A8 chip can sustain higher performances so you can play graphics-intensive games or enjoy video at higher frame rates for longer than ever while powering a larger display and incredible new features.",
            price = 665.00,
            images = listOf(R.drawable.apple_2020_mac_book_pro),
            categoryId = 1,
        ),
        Product(
            id = 4,
            name = "Lux Bar Soap - Even Complexion",
            description = "Lux Even Tone Beauty Soap 175g is enriched with a floral beauty oil and a complement of floral notes and cocoa butter, together with complexion-evening vitamin B3, leaving your skin fragrant and even-toned.\n",
            price = 2.38,
            images = listOf(R.drawable.lux_bar_soap),
            categoryId = 2,
        ),
        Product(
            id = 5,
            name = "Kirkland Minoxidil Hair Regrowth Treatment for Men",
            description = "Kirkland Minoxidil Hair Regrowth Treatment for Men - 60ml\n" +
                    "Minoxidil for men is a reduced 5% minox that easily absorbs into the scalp to revive dying hair follicles. It's 100% results guaranteed for treating bald spots of the head, receding hairlines etc, giving you the perfect look, so long as your hair is concerned. Note: This product is no magic. For some people it might not work as expected.",
            price = 52.0,
            images = listOf(
                R.drawable.kirkland_minoxidil_hair_regrowth1,
                R.drawable.kirkland_minoxidil_hair_regrowth2,
            ),
            categoryId = 2,
        ),
        Product(
            id = 6,
            name = "NIVEA Nourishing Cocoa Body Lotion",
            description = "This new-age body lotion has the goodness of natural oils and a fast absorbing lotion formula that provides deep nourishment for your skin while keeping it soft and smooth all day long. Enriched with coconut oil and Cocoa butter, Nivea Cocoa Nourishing Body Lotion provides deep moisture and smoothen away dullness.",
            price = 20.82,
            images = listOf(
                R.drawable.nivea_nourishing_cocoa,
                R.drawable.nivea_nourishing_cocoa2,
                R.drawable.nivea_nourishing_cocoa3,
            ),
            categoryId = 2,
        ),
        Product(
            id = 7,
            name = "Delron DK-001 Electric Kettle - 1.8 Liter ",
            description = "The Electric Kettle has been designed for your convenience and safety. The electric kettle has a powerful motor to heat water quickly, plus other amazing features such as an automatic shutdown. It is smartly designed for your easy use. Use this DELRON 1.8Litre Electric kettle and start your day on a sound note.It has a 3pin British standard plug. ",
            price = 42.0,
            images = listOf(R.drawable.delron_electric_kettle),
            categoryId = 3,
        ),
        Product(
            id = 8,
            name = "Lindy 12 Cubes Wardrobe 8 Doors - Brown",
            description = "This Plastic Portable Collapsible Wardrobe will take care of your storage neediness.\u200E\u200E This mobile wardrobe is versatile, durable and environmentally friendly. \u200E The structure and design of this closet includes hanging spaceship.\u200E\u200E It has front panel roll up for fast and easy access to your clothes and shoes.",
            price = 239.0,
            images = listOf(R.drawable.lindy_cubes_wardrobe),
            categoryId = 3,
        ),
        Product(
            id = 9,
            name = "Protech FR-115 Single Door Refrigerator - 91L Grey",
            description = "A refrigerator is probably the most important appliance in your house. In addition to keeping your food preserved, it's also the informal hub around which your family's day is organized. And, its door serves as a message center and chronicler of important family events. So when buying a fridge, it's vital that you pick one that best suits your needs and budget.\n",
            price = 724.0,
            images = listOf(
                R.drawable.protech_ingle_door_refrigerator,
                R.drawable.protech_ingle_door_refrigerator2
            ),
            categoryId = 3,
        ),
        Product(
            id = 10,
            name = "E-Life Digital Satellite HD TV - 32\" Black",
            description = "LED technology is what is among the best technologies currently on the market. In addition to using the latest technology to screen material, E-Life TV offers a quality/price ratio unbeatable by TVs competing for brands in the same category. E-Life TVs have the best TV aspect ratio, adjustable contrast and brightness features to complement picture quality when watching movies",
            price = 750.0,
            images = listOf(
                R.drawable.e_life_digital_satellite_tv,
                R.drawable.e_life_digital_satellite_tv2,
            ),
            categoryId = 4,
        ),
        Product(
            id = 11,
            name = "Triple Power TP-30 Bluetooth Subwoofer Speaker",
            description = "If you have tried the TPC20 and enjoyed it, then you will enjoy even more with the new Triple power C30 Subwoofer Speaker. Enhance your existing C20 with the C30 and Enjoy the immersive, clutter-free experience and get great sound all around by easily connecting the detachable surround speakers via the Aux cable. Bring a new dimension to your home audio experience and feel the power and depth of your favorite movies and TV shows.",
            price = 90.0,
            images = listOf(R.drawable.triple_power_bluetooth_subwoofer_speaker),
            categoryId = 4,
        ),
        Product(
            id = 12,
            name = "Mini Soundbar BS36 3D Stereo Surround Bass Home Theater",
            description = "he BS36 provides a innovative way to deliver immersive room-filling sound. The detachable speakers design gives you the versatility in placing the speakers in a horizontal layout at the base of your TV or as two separate free standing vertical speakers.",
            price = 250.50,
            images = listOf(
                R.drawable.kirkland_minoxidil_hair_regrowth1,
                R.drawable.kirkland_minoxidil_hair_regrowth2,
            ),
            categoryId = 4,
        ),
        Product(
            id = 13,
            name = "Apple 2020 MacBook Pro",
            description = "The 2020 MacBook Pro 13-inch Specs is Apple’s latest refresh of the 13-inch MacBook Pro line-up. This follows the introduction of the new 10th generation Intel processors which are only available in the 2020 models. This device comes with an Intel Core i5 running at a clock speed of 1.4 GHz. This can be boosted up to 3.9 GHz during process heavy usage.",
            price = 8900.0,
            images = listOf(
                R.drawable.apple_2020_mac_book_pro,
                R.drawable.apple_2020_mac_book_pro2,
            ),
            categoryId = 5,
        ),
        Product(
            id = 14,
            name = "Hp 24-XA0174JP",
            description = "BUILT FOR BUSINESS HP Business laptops and desktops are built for security and collaboration. With Military Grade (Mil) Specs and the latest security, it's the Business device your business needs.",
            price = 7200.0,
            images = listOf(R.drawable.hp_24_xa0174jp, R.drawable.hp_24_xa0174jp2),
            categoryId = 5,
        ),
        Product(
            id = 15,
            name = "Hp DeskJet 2710",
            description = "All the basics, now with easy-to-use features. Print, scan, and copy everyday documents, and get hassle-free wireless. Simple setup with HP Smart app means you’re ready on any device. Get ink delivered for a lot less – HP Instant Ink",
            price = 450.0,
            images = listOf(R.drawable.hp_desk_jet_2710, R.drawable.hp_desk_jet_27102),
            categoryId = 5,
        ),
        Product(
            id = 16,
            name = "Men's Sports Pants",
            description = "This Joggers is designed for individuals whose lifestyles are active, functional and adventurous. Design features modern and innovative details that appeal to everyone. Soft fleece, ribbed cuffs and adjustable drawcord provides added comfort. Sizing is designed for a slim/athletic fit. ",
            price = 55.0,
            images = listOf(R.drawable.mens_sports_pants, R.drawable.mens_sports_pants2),
            categoryId = 6,
        ),
        Product(
            id = 17,
            name = "4 Pack Short Sleeve T - Shirt",
            description = "This comfy T-Shirt is the best fit for your casual grooves. It is made from comfortable and durable cotton fabric. You can pair with Jeans or Chinos alongside Loafers or even Sneakers for a smart touch - this T-Shirt is ready for anything you’ve got on your casual calendar.",
            price = 73.0,
            images = listOf(R.drawable.pack_short_sleeve_t_shirt),
            categoryId = 6,
        ),
        Product(
            id = 18,
            name = "Fashion Low Top Lace Sneakers",
            description = "This pair in addition to being comfortable is very stylish. A must have for the classic man.This shoes is more convenient to wear shoes, showing a uniform and smooth line texture, simple and generous. Lightweight rubber outsole: with a soft, cushioned rubber sole for an elegant, stylish and simple. Clear texture design, Strong grip, non-slip, wear-resistant.",
            price = 39.0,
            images = listOf(R.drawable.fashion_low_top_lace_sneakers),
            categoryId = 6,
        ),
        Product(
            id = 19,
            name = "Fashion New Teen Boy Soccer Boots",
            description = "Our football designers strongly believe that kids aren't just mini adults. We therefore design products especially for young football players, and created the Agility 500 MG with a new wider sizing to fit children's feet. The heel and instep are wider for better support.",
            price = 106.0,
            images = listOf(
                R.drawable.fashion_new_teen_boy_soccer_boots,
                R.drawable.fashion_new_teen_boy_soccer_boots2,
                R.drawable.fashion_new_teen_boy_soccer_boots3,
                R.drawable.fashion_new_teen_boy_soccer_boots4,
            ),
            categoryId = 7,
        ),
        Product(
            id = 20,
            name = "Soccer Goalkeeper Gloves",
            description = "Non-slip training gloves for kids soccer goalkeeper youth and children breathable fitness gloves\n" +
                    "High quality latex palm, good slip resistance, strong abrasion resistanceNew upgrade of back hand material - good hand feeling, great flexibilityDouble layer can tighten wrist splint - can effectively tighten wrist muscles to avoid injuryRubber design of finger part - good elasticity to avoid finger injury",
            price = 88.0,
            images = listOf(R.drawable.soccer_goalkeeper_gloves),
            categoryId = 7,
        ),
        Product(
            id = 21,
            name = "Spalding Basketball",
            description = "The Spalding NBA basketball is a great ball for all weather conditions and can be played with indoor or outdoor, made with composite leather material which provides excellent durability and feel. Features a deep channel design for better dribble control and foam backing under the full-ball pebbling for precise ball handling.",
            price = 50.0,
            images = listOf(R.drawable.spalding_basketball, R.drawable.spalding_basketball2),
            categoryId = 7,
        ),
    )


    override val products: Result<ArrayList<Product>>
        get() = Result.Success(list)

    override fun productsCategory(categoryId: Int): Result<ArrayList<Product>> {
        val products = list.filter { p -> p.categoryId == categoryId }
        return Result.Success(products as ArrayList<Product>)
    }


}