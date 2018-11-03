package com.example.rxjavajdbcexample

import javax.persistence.*

@Entity
@Table(name = "foo")
data class Foo(@Id val id: Int = 0, @Column val name: String = "", @OneToOne @JoinColumn(name = "bar_id") val bar: Bar)