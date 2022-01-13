package ru.greencall.geospringdata.model

import javax.persistence.*

@Entity
data class City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "country_id")
    val country: Country,
)
