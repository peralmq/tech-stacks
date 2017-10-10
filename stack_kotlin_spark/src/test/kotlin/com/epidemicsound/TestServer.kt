package com.epidemicsound

import com.beust.klaxon.*
import kotlin.test.*
import org.junit.*
import com.github.kittinunf.fuel.Fuel
import spark.Spark

class TestServer {
    companion object {
        @BeforeClass @JvmStatic
        fun before() {
            main(emptyArray())
        }

        @AfterClass @JvmStatic
        fun after() {
            Spark.stop()
        }
    }

    @Test
    fun testRoot() {
        val actual = Fuel.get("http://localhost:4567/").responseString()
        assertEquals(200, actual.second.statusCode)
        assertEquals("Hello from Spark Kotlin!", actual.third.get())
    }

    val createTrackBody = json {
        mapOf("url" to "https://example.com")
    }.toString()

    @Test
    fun testCreateTrack() {
        val expected = json {
            mapOf(
                    "url" to "https://example.com",
                    "id" to "1"

            )
        }
        val actual = Fuel.post("http://localhost:4567/tracks/").body(createTrackBody).responseString()
        assertEquals(201, actual.second.statusCode)
        assertEquals(expected.toString(), actual.third.get())
    }

    @Test
    fun testGetTrack() {
        val (_, _, responseBody) = Fuel.post("http://localhost:4567/tracks/").body(createTrackBody).responseString()
        val id = (Parser().parse(responseBody.get().byteInputStream()) as JsonObject).string("id")
        val expected = json {
            mapOf(
                    "url" to "https://example.com",
                    "id" to id

            )
        }
        val actual = Fuel.get("http://localhost:4567/tracks/" + id).body(createTrackBody).responseString()
        assertEquals(200, actual.second.statusCode)
        assertEquals(expected.toString(), actual.third.get())
    }
}

