package nyx.pa1_example_server.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*

fun Application.configureCORS() {
    install(CORS){
        anyHost()
    }

}
