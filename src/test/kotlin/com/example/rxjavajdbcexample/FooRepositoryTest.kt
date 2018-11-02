package com.example.rxjavajdbcexample

import org.davidmoten.rx.jdbc.ConnectionProvider
import org.davidmoten.rx.jdbc.Database
import org.davidmoten.rx.jdbc.pool.NonBlockingConnectionPool
import org.davidmoten.rx.jdbc.pool.Pools
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.Flux
import javax.sql.DataSource

@RunWith(SpringRunner::class)
@DataJpaTest
class FooRepositoryTest {

    @Autowired
    lateinit var dataSource: DataSource

    var fooRepository: FooRepository? = null

    @Before
    fun before() {
        val pool: NonBlockingConnectionPool = Pools.nonBlocking()
                .maxPoolSize(1)
                .connectionProvider(ConnectionProvider.from(dataSource.connection))
                .build()

        fooRepository = FooRepository(Database.from(pool))
    }

    @Test
    fun findAllTest() {
        val foos: Flux<Foo>? = fooRepository?.findAll()
        assert(foos?.count()?.block() == 3L)
    }
}