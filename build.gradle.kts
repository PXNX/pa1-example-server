val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.30"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.30"
    id("org.jetbrains.kotlin.js") version "1.5.30" apply false
}

group = "nyx"
version = "0.0.1"
application {
    mainClass.set("nyx.pa1_example_server.ApplicationKt")
}

tasks.create("stage") {
    dependsOn("installDist")
}

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    maven("https://jitpack.io")
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-host-common:$ktor_version")
    implementation("io.ktor:ktor-metrics:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("io.ktor:ktor-html-builder:$ktor_version")
    /*  implementation("org.jetbrains.kotlin-wrappers:kotlin-css:1.0.0-pre.245-kotlin-1.5.30")
      implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.1-pre.244-kotlin-1.5.30")
      implementation("org.jetbrains.kotlin-wrappers:kotlin-styled-next:0.1-pre.244-kotlin-1.5.30")

      */
}