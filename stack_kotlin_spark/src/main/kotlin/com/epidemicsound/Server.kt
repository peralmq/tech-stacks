package com.epidemicsound

import com.beust.klaxon.*
import spark.*

var storage = mutableMapOf<String, Map<String, *>>()
var counter = 0

class Router {
    init {
        Spark.get("/") { _, _ ->
            "Hello from Spark Kotlin!"
        }

        Spark.post("/tracks/") { req, res ->
            val id = "${counter++}"
            val url = (Parser().parse(req.body().byteInputStream()) as JsonObject).string("url")
            val data = mapOf(
                    "id" to id,
                    "url" to url
            )
            storage[id] = data
            res.status(201)
            JsonObject(data).toJsonString()
        }

       Spark.get("/tracks/:id") { req, res ->
           val id = req.params("id")
           storage[id]?.let { data ->
               res.status(200)
               JsonObject(data).toJsonString()
           } ?: res.status(404)
        }
    }
}

fun main(args: Array<String>) {
    Router()
}
