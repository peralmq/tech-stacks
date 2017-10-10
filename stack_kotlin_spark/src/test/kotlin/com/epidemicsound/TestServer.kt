package com.epidemicsound

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
        val actual = Fuel.get("http://localhost:4567/").responseString().third.get()
        assertEquals("Hello from Spark Kotlin!", actual)
    }
}
