package refresh.onecake_refactoring.app.consumer.domain

interface OAuthRequestApi {
    fun requestToken(accessToken: String): OAuthUserInfo
}