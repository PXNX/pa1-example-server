package nyx.pa1_example_server.plugins

import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*

fun Application.configureMonitoring() {
    
    install(CallLogging) {
        level = Level.TRACE
        filter { call -> call.request.path().startsWith("/") }
    }

 /*   install(DefaultHeaders){
        header(HttpHeaders.Accept, "application/json")
        header(HttpHeaders.AccessControlAllowOrigin,"*")
    }

  */

   install(CORS) {
      /*  method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)

       */


        allowNonSimpleContentTypes = true
        allowCredentials = true
        allowSameOrigin = true

       anyHost()

    //    host("*", listOf("http", "https")) // frontendHost might be "*"
    }



}
