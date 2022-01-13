package ru.greencall.geospringdata.dao

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import ru.greencall.geospringdata.model.Country

interface CountryDao : CrudRepository<Country, Int> {

    @Query("select distinct c from Country c join fetch c.cities")
    fun findAllWithJoin(): List<Country>
}
