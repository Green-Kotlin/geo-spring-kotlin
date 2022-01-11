package ru.greencall.geospringdata.service

import org.springframework.stereotype.Service
import ru.greencall.geospringdata.model.Country

@Service
class CountryServiceImpl : CountryService {

    override fun getAllCountries(): List<Country> =
        listOf(
            Country(id =1, name = "Германия"),
            Country(id =2, name = "Франция"),
            Country(id =3, name = "Италия"),
        )
}