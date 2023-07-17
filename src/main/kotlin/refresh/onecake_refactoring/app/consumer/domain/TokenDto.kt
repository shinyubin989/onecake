package refresh.onecake_refactoring.app.consumer.domain

data class TokenDto(
    val accessToken: String,
    val refreshToken: String,
)
