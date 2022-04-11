package com.boltic28.composenavigation.data

import com.boltic28.composenavigation.data.model.Item
import com.boltic28.composenavigation.data.model.Order
import com.boltic28.composenavigation.data.model.Shop
import com.boltic28.composenavigation.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {

    private var _counter = 0
    val counter
        get() = _counter++

    val users = listOf(
        User(1, "Adam", 34),
        User(2, "Alex", 22),
        User(3, "Jack", 47),
    )

    val shops = listOf(
        Shop(1001, "Bill and sons"),
        Shop(1002, "Will and sons"),
        Shop(1003, "Andy and sons"),
        Shop(1004, "Jim's chicken"),
        Shop(1005, "Funny chicken"),
        Shop(1006, "Bob's kitchen"),
    )

    val items = listOf(
        Item(10001, 33.4, "soup"),
        Item(10002, 13.7, "purge"),
        Item(10003, 38.3, "potato"),
        Item(10004, 23.9, "milk"),
        Item(10005, 37.2, "coffee"),
        Item(10006, 53.5, "black tea"),
        Item(10007, 13.0, "pancake"),
    )

    val orders = listOf(
        Order(100001, 1001, 1,items.filter { it.cost > 33.0}),
        Order(100002, 1001, 3,items.filter { it.cost < 33.0}),
        Order(100003, 1003, 2,items.filter { it.cost in 12.0..25.0}),
        Order(100004, 1006, 2,items.filter { it.cost in 22.0..35.0}),
        Order(100005, 1002, 3,items.filter { it.cost > 40.0}),
        Order(100006, 1004, 3,items.filter { it.cost < 20}),
        Order(100007, 1002, 1,items.filter { it.cost in 30.0..40.0}),
    )

    fun getOrdersForShop(shop: Shop): List<Order> = orders.filter { it.shopId == shop.id }

    fun getOrdersForUser(user: User): List<Order> = orders.filter { it.userId ==user.id }

}