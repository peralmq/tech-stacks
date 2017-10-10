package com.epidemicsound

import spark.kotlin.*

class Router {
    init {
        get("/") {
            "Hello from Spark Kotlin!"
        }
    }
}

fun main(args: Array<String>) {
    Router()
}
