package com.epidemicsound

import com.github.andrewoma.kwery.core.DefaultSession
import com.github.andrewoma.kwery.core.dialect.MysqlDialect
import com.github.andrewoma.kwery.core.interceptor.LoggingInterceptor
import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.features.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.host.*
import org.jetbrains.ktor.netty.*
import org.jetbrains.ktor.routing.*
import org.jetbrains.ktor.response.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/db") {

            try {
                val connection: Connection = DriverManager.getConnection("jdbc:mysql://ts_user:ts_pw@db_mysql/ts_db")
                val session = DefaultSession(connection, MysqlDialect(), LoggingInterceptor())
                val result = session.select("SELECT 1 AS status") { row -> row.int("status") }
                if (result[0] == 1) {
                    call.respondText("Connected to database", ContentType.Text.Html)
                } else {
                    call.respondText("Not connected to database", ContentType.Text.Html)
                }
            } catch (e: SQLException) {
                call.respondText("Not connected to database", ContentType.Text.Html)
            }
        }

        get("/") {
            call.respondText("Hello from the Kotlin world!", ContentType.Text.Html)
        }
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080, watchPaths = listOf("App"), module = Application::module).start()
}