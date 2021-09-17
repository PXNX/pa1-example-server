package nyx.pa1_example_server

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import nyx.pa1_example_server.plugins.configureMonitoring
import nyx.pa1_example_server.plugins.configureRouting
import nyx.pa1_example_server.plugins.configureSerialization

fun main() {
    embeddedServer(CIO, port = System.getenv("PORT").toInt()/*8080*/) {
        configureRouting()
        configureMonitoring()
        configureSerialization()
    }.start(wait = true)
}
