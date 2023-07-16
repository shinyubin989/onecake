package refresh.onecake_refactoring.app.seller.domain

data class Menu(
    val store: Store,
    val name: String,
    val price: Int,
    val img: String?,
    val description: String,
    val deleted: Boolean
)
