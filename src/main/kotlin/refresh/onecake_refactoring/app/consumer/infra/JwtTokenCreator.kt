package refresh.onecake_refactoring.app.consumer.infra

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.data.redis.core.RedisTemplate
import refresh.onecake_refactoring.app.common.UserType
import refresh.onecake_refactoring.app.consumer.domain.TokenCreator
import refresh.onecake_refactoring.app.consumer.domain.TokenDto
import java.time.Instant
import java.time.Period
import java.util.*

class JwtTokenCreator(
    private val redisTemplate: RedisTemplate<String, Any>,
    private val jwtTokenSecretKey: JwtTokenSecretKey
) : TokenCreator {

    override fun create(id: Long, type: UserType, accessTokenExpireTime: Period, refreshTokenExpireTime: Period) : TokenDto {
        val key = jwtTokenSecretKey.getSecretKey()
        val now = Instant.now()
        val accessTokenExpiresIn = now.plus(accessTokenExpireTime)
        val refreshTokenExpiresIn = now.plus(refreshTokenExpireTime)

        val accessToken = Jwts.builder()
            .claim("id", id)
            .claim("type", type)
            .setIssuedAt(Date.from(now))
            .setExpiration(Date.from(accessTokenExpiresIn))
            .signWith(key, SignatureAlgorithm.HS512)
            .compact()
        val refreshToken = Jwts.builder()
            .setExpiration(Date.from(refreshTokenExpiresIn))
            .claim("id", id)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact()


        //TODO : redis 분리
        redisTemplate.opsForValue().set("refreshToken:$id", refreshToken)

        return TokenDto(accessToken, refreshToken)
    }

}