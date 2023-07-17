package refresh.onecake_refactoring.app.consumer.domain

import refresh.onecake_refactoring.app.common.UserType
import java.time.Period

interface TokenCreator {
    fun create(id: Long, type: UserType, accessTokenExpireTime: Period, refreshTokenExpireTime: Period) : TokenDto
}