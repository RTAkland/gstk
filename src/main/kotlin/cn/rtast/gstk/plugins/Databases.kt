package cn.rtast.gstk.plugins

import cn.rtast.gstk.entity.Poems
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun configureDatabases() {
    Database.connect(
        url = "jdbc:sqlite:file:./data.db",
        driver = "org.sqlite.JDBC",
    ).also {
        transaction {
            SchemaUtils.create(Poems)
        }
    }
}
