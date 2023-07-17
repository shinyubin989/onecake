package refresh.onecake_refactoring.app.consumer.domain

interface ConsumerState {


    fun delete(onDelete: () -> Unit)
    fun ban(onBan: () -> Unit)
}