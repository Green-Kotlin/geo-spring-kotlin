package ru.greencall.geospringdata.dao

import org.springframework.data.repository.CrudRepository
import ru.greencall.geospringdata.model.Country

interface CountryDao : CrudRepository<Country, Int> {}
