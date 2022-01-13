package ru.greencall.geospringdata.exception

data class ApiError(
    val errorCode: String,
    val description: String,
) {
}