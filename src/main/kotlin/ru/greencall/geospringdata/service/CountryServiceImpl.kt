package ru.greencall.geospringdata.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.greencall.geospringdata.dao.CountryDao
import ru.greencall.geospringdata.dto.CountryDto
import ru.greencall.geospringdata.exception.CountryNotFoundException
import ru.greencall.geospringdata.model.Country

@Service
class CountryServiceImpl(
    private val countryDao: CountryDao,
) : CountryService {

    override fun getAllCountries(): List<Country> =
        countryDao.findAll().toList()

    override fun getById(id: Int): Country =
        countryDao.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)

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

    override fun deleteById(id: Int) {
        countryDao.deleteById(id)
    }

}
