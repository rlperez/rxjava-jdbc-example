package com.example.rxjavajdbcexample

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import io.reactivex.Flowable
import org.davidmoten.rx.jdbc.Database

@Repository
class FooRepository(private val db: Database) {

    fun findAll(): Flux<Foo> {
        val fooFlowable: Flowable<Foo> =
                db.select("select id, name from foo")
                        .get { resultSet ->
                            Foo(resultSet.getInt(1), resultSet.getString(2))
                        }

        return Flux.from(fooFlowable)
    }
}