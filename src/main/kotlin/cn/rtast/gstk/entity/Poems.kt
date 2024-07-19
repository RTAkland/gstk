/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/7/18
 */


package cn.rtast.gstk.entity

import cn.rtast.gstk.poems
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction


data class Poem(
    val title: String,
    val author: String,
    val content: String,
)

object Poems : Table("poem") {
    val id: Column<Int> = integer("id").autoIncrement()
    val title: Column<String> = varchar("title", 255)
    val content: Column<String> = varchar("content", 512)
    val author: Column<String> = varchar("author", 100)
    override val primaryKey = PrimaryKey(id)
}

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }

suspend fun getRandomPoem(): Poem {
    if (poems.isEmpty()) {
        val result = dbQuery {
            Poems.selectAll()
                .map { Poem(it[Poems.title], it[Poems.author], it[Poems.content]) }
        }
        poems.addAll(result)
    }
    return poems.random()
}
