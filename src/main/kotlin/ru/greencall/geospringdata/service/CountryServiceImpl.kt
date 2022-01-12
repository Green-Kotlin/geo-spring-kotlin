package ru.greencall.geospringdata.service

import org.springframework.stereotype.Service
import ru.greencall.geospringdata.dao.CountryDao
import ru.greencall.geospringdata.dto.CountryDto
import ru.greencall.geospringdata.model.Country

@Service
class CountryServiceImpl(
    private val countryDao: CountryDao,
) : CountryService {

    override fun getAllCountries(): List<Country> =
        countryDao.findAll().toList()

    override fun getById(id: Int): Country =
        countryDao.findById(id).orElseThrow()

    override fun create(country: CountryDto) {
        val country = Country(
            name = country.name,
        )
        countryDao.save(country)
    }

    override fun update(id: Int, country: CountryDto) {
        countryDao.findById(id).ifPresent { oldCountry ->
            val newCountry = oldCountry.copy(
                name = country.name,
            )
            countryDao.save(newCountry)
        }
    }

}
