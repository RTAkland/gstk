/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/7/18
 */


package cn.rtast.gstk

import cn.rtast.gstk.entity.Poem
import com.google.gson.Gson
import com.google.gson.GsonBuilder

val gson: Gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()

val poems = mutableListOf<Poem>()