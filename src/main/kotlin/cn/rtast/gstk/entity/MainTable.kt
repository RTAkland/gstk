/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/7/18
 */


package cn.rtast.gstk.entity

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object MainTable : Table("poem") {
    val id: Column<Int> = integer("id").autoIncrement()
    val title: Column<String> = varchar("title", 255)
    val content: Column<String> = varchar("content", 512)
    val author: Column<String> = varchar("author", 100)
    override val primaryKey = PrimaryKey(id)
}