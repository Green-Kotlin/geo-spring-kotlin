package ru.greencall.geospringdata.service

import ru.greencall.geospringdata.dto.CountryDto
import ru.greencall.geospringdata.model.Country

interface CountryService {

    fun getAllCountries(): List<Country>

    fun getById(id: Int): Country

    fun create(country: CountryDto)

    fun update(id: Int, country: CountryDto)

    fun deleteById(id: Int)
}