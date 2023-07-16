package refresh.onecake_refactoring.app.seller.domain

data class Seller(
    val name: String,
    val phoneNumber: String,
    val profileImg: String?,
    val store: Store,
    val deleted: Boolean,
    val blocked: Boolean
)

