package com.test.worldpaytest.data.models.response

import com.google.gson.annotations.SerializedName

/**
 * @author Filippo
 */
class Links(
        @SerializedName("payments:cancel") val paymentCancel: PaymentsAction,
        @SerializedName("payments:settle") val paymentSettle: PaymentsAction,
        @SerializedName("payments:partialSettle") val paymentPartialSettle: PaymentsAction,
        @SerializedName("payments:events") val paymentEvents: PaymentsAction,
        curies : Array<Curie>
)