package refresh.onecake_refactoring.app.consumer.infra

import org.springframework.stereotype.Component
import refresh.onecake_refactoring.app.consumer.domain.Consumer
import refresh.onecake_refactoring.app.consumer.domain.ConsumerStorage

@Component
class JpaConsumerStorage(private val repository: JpaConsumerRepository) : ConsumerStorage {
    override fun existsByClientId(clientId: String): Boolean {
        return repository.existsByClientId(clientId)
    }

    override fun findByClientId(clientId: String): Consumer {
        return toConsumer(repository.findByClientId(clientId))
    }

    override fun save(consumer: Consumer): Consumer {
        return toConsumer(repository.save(ConsumerEntity(consumer.clientId, consumer.name, consumer.phoneNumber, consumer.profileImg, ConsumerStateMapper.isDeleted(consumer), ConsumerStateMapper.isBanned(consumer))))
    }




    private fun toConsumer(consumerEntity: ConsumerEntity): Consumer {
        return Consumer(consumerEntity.id, consumerEntity.clientId, consumerEntity.name, consumerEntity.phoneNumber, consumerEntity.profileImg, ConsumerStateMapper.toState(consumerEntity.deleted, consumerEntity.banned))
    }
}