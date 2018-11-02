package com.example.rxjavajdbcexample

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "foo")
data class Foo(@Id val id: Int = 0, @Column val name: String = "")