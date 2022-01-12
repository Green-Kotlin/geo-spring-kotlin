package ru.greencall.geospringdata.service

import org.springframework.stereotype.Service
import ru.greencall.geospringdata.dao.CountryDao
import ru.greencall.geospringdata.model.Country

@Service
class CountryServiceImpl(
    private val countryDao: CountryDao,
) : CountryService {

    override fun getAllCountries(): List<Country> =
        countryDao.findAll().toList()

}