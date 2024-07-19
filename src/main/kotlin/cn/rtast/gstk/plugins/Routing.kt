package cn.rtast.gstk.plugins

import cn.rtast.gstk.entity.getRandomPoem
import cn.rtast.gstk.util.toJson
import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.mustache.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(ContentNegotiation) {
        gson {}
    }
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates")
    }
    routing {
        get("/") {
            call.respond(MustacheContent("index.mustache", null))
        }
        get("/api/poem") {
            call.respond(getRandomPoem().toJson())
        }
    }
}
