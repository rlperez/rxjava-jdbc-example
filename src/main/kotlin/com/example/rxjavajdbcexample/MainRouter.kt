package com.example.rxjavajdbcexample

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class MainRouter(private val mainHandler: MainHandler) {
    @Bean
    fun routes() = router {
        GET("/foos", mainHandler::getFoos)
    }
}