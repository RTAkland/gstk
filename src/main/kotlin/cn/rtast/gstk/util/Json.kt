/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/7/18
 */


package cn.rtast.gstk.util

import cn.rtast.gstk.gson
import com.google.gson.reflect.TypeToken

fun Any.toJson(): String {
    return gson.toJson(this)
}

inline fun <reified T> String.fromJson(): T {
    return gson.fromJson(this, T::class.java)
}

inline fun <reified T> String.fromArrayJson(): T {
    return gson.fromJson(this, object : TypeToken<T>() {}.type)
}