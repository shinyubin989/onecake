package refresh.onecake_refactoring.app.consumer.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.core.RedisTemplate
import refresh.onecake_refactoring.app.consumer.domain.ConsumerAuthProvider
import refresh.onecake_refactoring.app.consumer.domain.ConsumerStorage
import refresh.onecake_refactoring.app.consumer.domain.OAuthRequestApi
import refresh.onecake_refactoring.app.consumer.domain.TokenCreator

@Configuration("ConsumerBeanConfig")
class BeanConfig(
    private val redisTemplate: RedisTemplate<String, Any>
) {

    @Bean
    fun consumerStorage(jpaConsumerRepository: JpaConsumerRepository): ConsumerStorage {
        return JpaConsumerStorage(jpaConsumerRepository)
    }

    @Bean
    fun oAuthRequestApi(): OAuthRequestApi {
        return KakaoOAuthRequestApi()
    }

    @Bean
    fun jwtTokenSecretKey(): JwtTokenSecretKey {
        return JwtTokenSecretKey()
    }

    @Bean
    fun tokenCreator(): TokenCreator {
        return JwtTokenCreator(redisTemplate, jwtTokenSecretKey())
    }

    @Bean
    fun consumerAuthProvider(consumerStorage: ConsumerStorage): ConsumerAuthProvider {
        return ConsumerAuthProvider(consumerStorage, oAuthRequestApi(), tokenCreator())
    }
}