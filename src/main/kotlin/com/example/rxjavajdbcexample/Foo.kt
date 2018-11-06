package com.example.rxjavajdbcexample

import org.davidmoten.rx.jdbc.annotations.Query
import javax.persistence.*

@Entity
@Table(name = "foo")
@Query("select id, name, bar_id from bar")
interface Foo {
    @Id
    fun id(): Int

    @Column
    fun name(): String

    @OneToOne
    @JoinColumn(name = "bar_id")
    fun bar(): Bar
}
