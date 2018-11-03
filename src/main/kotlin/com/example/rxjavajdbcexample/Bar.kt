package com.example.rxjavajdbcexample

import javax.persistence.*

@Entity
@Table(name = "bar")
data class Bar(@Id val id: Int = 0, @Column val value: String)