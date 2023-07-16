package refresh.onecake_refactoring.app.consumer.domain

data class Consumer (
    val name: String,
    val phoneNumber: String,
    val profileImg: String?,
    val deleted : Boolean
)

