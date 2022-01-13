package ru.greencall.geospringdata.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.greencall.geospringdata.dao.CountryDao
import ru.greencall.geospringdata.dto.CityDto
import ru.greencall.geospringdata.dto.CountryDto
import ru.greencall.geospringdata.exception.CountryNotFoundException
import ru.greencall.geospringdata.model.City
import ru.greencall.geospringdata.model.Country

@Service
class CountryServiceImpl(
    private val countryDao: CountryDao,
) : CountryService {

    override fun getAllCountries(): List<CountryDto> =
        countryDao.findAllWithJoin().map {
            it.toDto()
        }

    override fun getById(id: Int): CountryDto =
        countryDao.findByIdOrNull(id)
            ?.toDto()
            ?: throw CountryNotFoundException(id)

    override fun create(country: CountryDto) {
        val country = Country(
            name = country.name,
        )
        countryDao.save(country)
    }

    override fun update(id: Int, country: CountryDto) {
        val oldCountry = countryDao.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)
        val newCountry = oldCountry.copy(
                name = country.name,
            )
            countryDao.save(newCountry)
        }

    override fun deleteById(id: Int) {
        countryDao.deleteById(id)
    }

    private fun Country.toDto(): CountryDto =
        CountryDto(
            name = this.name,
            cities = this.cities
                .map { city ->
                    CityDto(
                        name = city.name
                    )
                }
        )
}
