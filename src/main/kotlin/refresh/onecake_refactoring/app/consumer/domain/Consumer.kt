package refresh.onecake_refactoring.app.consumer.domain

data class Consumer(val id: Long?, val clientId: String, val name: String, val phoneNumber: String, val profileImg: String?, val state: ConsumerState)

