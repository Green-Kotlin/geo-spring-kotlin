package ru.greencall.geospringdata.model

import javax.persistence.*

@Entity
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String,
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    val cities: List<City> = emptyList(),
)
