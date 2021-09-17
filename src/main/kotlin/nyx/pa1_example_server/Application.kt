package nyx.pa1_example_server

import io.ktor.features.*
import io.ktor.http.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import nyx.pa1_example_server.plugins.configureMonitoring
import nyx.pa1_example_server.plugins.configureRouting
import nyx.pa1_example_server.plugins.configureSerialization

fun main() {
    embeddedServer(CIO, port = /*System.getenv("PORT").toInt()*/8084,host="localhost") {
        configureSerialization()
        configureRouting()
        configureMonitoring()
    }.start(wait = true)
}
