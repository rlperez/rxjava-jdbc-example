package com.example.rxjavajdbcexample

import javax.persistence.*

@Entity
@Table(name = "foo")
interface Foo {
    @Id
    fun id(): Int

    @Column
    fun name(): String

    @OneToOne
    @JoinColumn(name = "bar_id")
    fun bar(): Bar
}
