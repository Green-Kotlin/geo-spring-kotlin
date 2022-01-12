package ru.greencall.geospringdata.service

import ru.greencall.geospringdata.model.Country

interface CountryService {

    fun getAllCountries(): List<Country>

    fun getById(id: Int): Country
}