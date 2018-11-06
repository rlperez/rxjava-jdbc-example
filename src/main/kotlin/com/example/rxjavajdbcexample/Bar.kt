package com.example.rxjavajdbcexample

import org.davidmoten.rx.jdbc.annotations.Query
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "bar")
@Query("select id, value from bar")
interface Bar {
    @Id
    fun id(): Int
    @Column
    fun value(): String
}
