package refresh.onecake_refactoring.app.consumer.domain

interface ConsumerStorage {

    fun existsByClientId(clientId: String): Boolean
    fun findByClientId(clientId: String): Consumer

    fun save(consumer: Consumer): Consumer
}