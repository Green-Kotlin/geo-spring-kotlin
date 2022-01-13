package ru.greencall.geospringdata.controller

import org.springframework.web.bind.annotation.*
import ru.greencall.geospringdata.dto.CountryDto
import ru.greencall.geospringdata.model.Country
import ru.greencall.geospringdata.service.CountryService

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: CountryService,
) {

    @GetMapping
    fun getAllCountries(): List<Country> = countryService.getAllCountries()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Country = countryService.getById(id)

    @PostMapping
    fun create(@RequestBody dto: CountryDto) {
        countryService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: CountryDto) {
        countryService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        countryService.deleteById(id)
    }
}