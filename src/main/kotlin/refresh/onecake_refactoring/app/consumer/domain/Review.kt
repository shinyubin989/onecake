package refresh.onecake_refactoring.app.consumer.domain

import refresh.onecake_refactoring.app.seller.domain.Store

data class Review(
    val store: Store,
    val consumer: Consumer,
    val star: Int,
    val content: String,
    val img: String?,
    val deleted: Boolean,
)
