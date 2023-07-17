package refresh.onecake_refactoring.app.consumer.infra

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import refresh.onecake_refactoring.app.consumer.domain.OAuthRequestApi
import refresh.onecake_refactoring.app.consumer.domain.OAuthUserInfo

@Component
class KakaoOAuthRequestApi : OAuthRequestApi {

    val kakaoUrl = WebClient.create("https://kapi.kakao.com/v2/user/me")

    override fun requestToken(accessToken: String): OAuthUserInfo {
        return kakaoUrl.get()
            .headers { it.setBearerAuth(accessToken) }
            .retrieve()
            .bodyToMono(KakaoOAuthResponse::class.java)
            .map { OAuthUserInfo(it.id) }
            .block() ?: throw KakaoTokenRequestException("카카오 토큰 요청 실패")
    }
}