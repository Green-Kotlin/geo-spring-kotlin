package ru.greencall.geospringdata.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.greencall.geospringdata.model.Country
import ru.greencall.geospringdata.service.CountryService

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: CountryService,
) {

    @GetMapping
    fun getAllCountries(): List<Country> = countryService.getAllCountries()
}