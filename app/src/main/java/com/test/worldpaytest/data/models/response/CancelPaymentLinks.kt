package com.test.worldpaytest.data.models.response

import com.google.gson.annotations.SerializedName

/**
 * @author Filippo
 */
class CancelPaymentLinks(
        @SerializedName("payments:events") val paymentEvents: PaymentsAction,
        curies : Array<Curie>
)