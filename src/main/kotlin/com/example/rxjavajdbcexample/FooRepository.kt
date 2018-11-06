package com.example.rxjavajdbcexample

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import io.reactivex.Flowable
import org.davidmoten.rx.jdbc.Database

@Repository
class FooRepository(private val db: Database) {

    fun findAll(): Flux<Foo> {
        val fooFlowable: Flowable<Foo> =
                db.select("select f.id, f.name, f.bar_id, b.id, b.value from foo f, bar b where f.bar_id = b.id")
                        .autoMap(Foo::class.java)

        return Flux.from(fooFlowable)
    }
}
