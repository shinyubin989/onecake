package refresh.onecake_refactoring.app.consumer.infra

import jakarta.persistence.Entity
import refresh.onecake_refactoring.app.common.BaseTimeEntity

@Entity
class ConsumerEntity(

    val clientId: String,

    val name: String,

    val phoneNumber: String,

    val profileImg: String?,

    val deleted: Boolean,

    val banned: Boolean,
) : BaseTimeEntity()