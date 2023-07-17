package refresh.onecake_refactoring.app.consumer.infra

import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import javax.crypto.SecretKey

class JwtTokenSecretKey {
    private val secretKey = "U35s8kDow75DPdF429NdfL3wEkf23jdg6vLEF8s9jefF8"

    fun getSecretKey(): SecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
}