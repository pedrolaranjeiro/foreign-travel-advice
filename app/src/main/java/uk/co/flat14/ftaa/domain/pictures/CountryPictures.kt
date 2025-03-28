package uk.co.flat14.ftaa.domain.pictures

import kotlinx.serialization.Serializable

@Serializable
data class CountryPictures(
    val name: String,
    val picturesLinks: List<String>,
)
