package refresh.onecake_refactoring.app.seller.domain

import java.time.LocalDate

data class StoreInfo(
    val openTime: LocalDate,
    val closeTime: LocalDate,
    val address: String,
)
