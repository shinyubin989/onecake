package refresh.onecake_refactoring.app.consumer.domain

import jakarta.transaction.Transactional
import refresh.onecake_refactoring.app.common.UserType
import java.time.Period

class ConsumerAuthProvider(
    private val consumerStorage: ConsumerStorage,
    private val oAuthRequestApi: OAuthRequestApi,
    private val tokenCreator: TokenCreator
) {

    @Transactional
    fun login(accessToken: String, name: String, phoneNumber: String) : TokenDto {
        val userInfo = oAuthRequestApi.requestToken(accessToken)
        val consumer = if (consumerStorage.existsByClientId(userInfo.clientId).not())
            consumerStorage.save(Consumer(null, userInfo.clientId, name, phoneNumber, null, DefaultState()))
        else consumerStorage.findByClientId(userInfo.clientId)
        return tokenCreator.create(consumer.id!!, UserType.CONSUMER, Period.ofDays(1), Period.ofDays(7))
    }
}