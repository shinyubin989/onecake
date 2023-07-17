package refresh.onecake_refactoring.app.consumer.infra

import refresh.onecake_refactoring.app.consumer.domain.*

class ConsumerStateMapper {

    companion object{
        fun isDeleted(consumer: Consumer): Boolean {
            return consumer.state is DeletedState || consumer.state is DeletedAndBannedState
        }
        fun isBanned(consumer: Consumer): Boolean {
            return consumer.state is BannedState || consumer.state is DeletedAndBannedState
        }
        fun toState(deleted: Boolean, banned: Boolean) : ConsumerState{
            return when {
                deleted && banned -> DeletedAndBannedState()
                deleted -> DeletedState()
                banned -> BannedState()
                else -> DefaultState()
            }
        }

    }
}