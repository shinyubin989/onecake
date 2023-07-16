package refresh.onecake_refactoring.app.seller.domain

data class Store(
    val name: String,
    val mainImg: String?,
    val description: String,
    val info: StoreInfo,
    val deleted: Boolean
)
