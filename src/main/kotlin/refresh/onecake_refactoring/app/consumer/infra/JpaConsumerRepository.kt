package refresh.onecake_refactoring.app.consumer.infra

import org.springframework.data.jpa.repository.JpaRepository

interface JpaConsumerRepository : JpaRepository<ConsumerEntity, Long>{
    fun existsByClientId(clientId: String): Boolean
    fun findByClientId(clientId: String): ConsumerEntity
}