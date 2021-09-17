package nyx.pa1_example_server.plugins

import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx.pa1_example_server.data.Repository

fun Application.configureRouting() {

    val articlePreviews = Repository.getPreviews()
    val articleDetails = Repository.getDetails()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        
        get("previews") {
            call.respond(articlePreviews)
        }

        get("detail/{id}") {
            //FIXME: Exception handling if supplied parameter not Int might be nice.
            call.respond(articleDetails[call.parameters["id"]?.toIntOrNull()!!])
        }
    }
}
