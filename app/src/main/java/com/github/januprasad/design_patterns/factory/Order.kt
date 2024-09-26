package com.github.januprasad.design_patterns.factory

import java.util.Locale

/**
 * First, we’ll create an interface for our food orders.
 */
interface Order {
    fun orderDetails(): String
}

/**
 * Second, we will create a list of the food orders
 */
class VegOrder(private val dishName: String) : Order {
    override fun orderDetails(): String {
        return "Veg Order: $dishName"
    }
}

class NonVegOrder(private val dishName: String) : Order {
    override fun orderDetails(): String {
        return "Non-Veg Order: $dishName"
    }
}

object OrderFactory {
    fun createOrder(orderType: String, dishName: String): Order {
        return when (orderType.lowercase(Locale.ROOT)) {
            "veg" -> VegOrder(dishName)
            "nonveg" -> NonVegOrder(dishName)
            else -> throw IllegalArgumentException("Unknown order type")
        }
    }
}
