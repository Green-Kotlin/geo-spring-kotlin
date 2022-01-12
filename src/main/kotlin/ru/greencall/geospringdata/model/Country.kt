package ru.greencall.geospringdata.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Country(
    @Id
    val id: Int,
    val name: String,
)
