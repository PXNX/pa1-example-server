package nyx.pa1_example_server.plugins

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.title
import nyx.pa1_example_server.data.Repository

fun Application.configureRouting() {

    val articlePreviews = Repository.getPreviews().toList()
    val articleDetails = Repository.getDetails().toList()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("previews") {
            call.respond(articlePreviews)
        }

        //TODO rename to article
        get("detail/{id}") {
            //FIXME: Exception handling if supplied parameter not Int might be nice.
            call.respond(articleDetails[call.parameters["id"]?.toIntOrNull()!!])
        }


        get("pwa") {
            val name = "HHH"
            call.respondHtml(HttpStatusCode.OK) {
                head {
                    title {
                        +name
                    }
                }
                body {
                    h1 {
                        +"Hello from $name!"
                    }
                }

/*

                styledDiv {
                    css {
                        display = Display.flex
                        justifyContent = JustifyContent.center
                        marginTop = 80.px
                    }

                    styledDiv {
                        css {
                            width = if (isLandscape) LinearDimension("50%") else LinearDimension.fillAvailable
                        }

                        if (props.previews.isNotEmpty()) {

                            props.previews.forEachIndexed { index, article ->

                                /*
                                if (index % 12 == 0) {
                                    styledDiv {
                                        css {
                                            backgroundColor = Color("#016b6b")
                                            width = LinearDimension.fillAvailable
                                            borderRadius = LinearDimension("16px")
                                            padding = "1.5rem"
                                            marginBottom = LinearDimension("1rem")
                                        }


                                        +" Nachrichten rund um Militär- und Protest-Aktionen weltweit und brandaktuell 🔰"



                                        when (feedProps.pushManagerState) {
                                            is PushManagerState.NotSubscribed -> {
                                                button {
                                                    attrs {
                                                        onClickFunction = {
                                                            scope.launch {
                                                                pushManager.subscribeUser(feedProps.pushManagerState as PushManagerState.NotSubscribed) {
                                                                    console.log("Sending subscription to server...")
                                                                }
                                                            }
                                                        }
                                                    }
                                                    +"Click here to subscribe to push notifications"
                                                }
                                            }
                                            is PushManagerState.Subscribed -> {
                                                h2 {
                                                    +"User is subscribed to Push API"
                                                }
                                                button {
                                                    attrs {
                                                        onClickFunction = {
                                                            scope.launch {
                                                                pushManager.unsubscribeUser(feedProps.pushManagerState as PushManagerState.Subscribed)
                                                            }
                                                        }
                                                    }
                                                    +"Click here to unsubscribe"
                                                }
                                            }
                                            PushManagerState.NotSupported -> h2 {
                                                +"Push API is not supported on this browser"
                                            }
                                            PushManagerState.Loading, PushManagerState.NotLoaded -> loadingComponent()
                                        }



                                        styledButton {
                                            +"Auf dem Laufenden bleiben (push notification)"

                                            attrs {

                                            }
                                        }
                                    }
                                }
                                 */

                                styledDiv {
                                    css {
                                        backgroundColor = Color("#12273d")
                                        width = LinearDimension.fillAvailable
                                        borderRadius = LinearDimension("16px")
                                        marginBottom = LinearDimension("1rem")
                                    }

                                    /*  styledImg(src = article.imageUrl) {
                                          attrs {
                                              width = "100%"
                                              height = "120px"
                                          }

                                          css {
                                              borderTopRightRadius = LinearDimension("16px")
                                              borderTopLeftRadius = LinearDimension("16px")
                                          }
                                      }

                                     */

                                    styledDiv {
                                        css {
                                            padding = "0.75rem"
                                        }

                                        styledP {
                                            +article.title

                                            css {
                                                fontWeight = FontWeight.bold
                                                color = Color("#fff")
                                            }
                                        }

                                        /*  styledP {
                                              +article.tags

                                              css {
                                                  color = Color("#fff")
                                              }
                                          }

                                         */
                                    }
                                }
                            }

                            styledDiv {
                                css {
                                    backgroundColor = Color("#016b6b")
                                    width = LinearDimension.fillAvailable
                                    borderRadius = LinearDimension("16px")
                                    marginBottom = LinearDimension("12rem")
                                    padding = "1.5rem"
                                }


                                +" Nachrichten rund um Militär- und Protest-Aktionen weltweit und brandaktuell 🔰"





                                styledButton {
                                    +"Auf dem Laufenden bleiben (push notification)"

                                    attrs {

                                    }
                                }

                            }
                        } else {
                            styledP {
                                +"Keine Meldungen verfügbar."

                                css {
                                    fontWeight = FontWeight.bold
                                    color = Color("#fff")
                                }
                            }
                        }




                    }
                }

 */
            }
        }
    }
}
