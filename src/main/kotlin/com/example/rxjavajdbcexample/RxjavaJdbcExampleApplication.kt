package com.example.rxjavajdbcexample

import org.davidmoten.rx.jdbc.Database
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class RxjavaJdbcExampleApplication {

    @Bean
    internal fun db(): Database {
        return Database.from("jdbc:memory:derby:demo", 5)
    }

}

fun main(args: Array<String>) {
    runApplication<RxjavaJdbcExampleApplication>(*args)
}
