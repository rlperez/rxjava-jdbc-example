package com.example.rxjavajdbcexample

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class MainHandler(private val fooRepository: FooRepository) {
    fun getFoos(req: ServerRequest): Mono<ServerResponse> = ServerResponse
            .ok()
            .body(fromObject(fooRepository.findAll()))
}