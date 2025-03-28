package uk.co.flat14.ftaa.data.pictures




data class UnsplashPictureListResponse(
    val total : Int,
    val results: List<UnsplashPictureResult>
)


data class PictureUrl (
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
)

data class UnsplashPictureResult (
    val id: String,
    val width: String,
    val height: String,
    val urls: PictureUrl,
    val likes: Int
)
