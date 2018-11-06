package com.example.rxjavajdbcexample

import javax.persistence.*

@Entity
@Table(name = "bar")
interface Bar {
    @Id
    fun id(): Int
    @Column
    fun value(): String
}
