package com.test.worldpaytest.data.models.response

import com.google.gson.annotations.SerializedName

/**
 * @author Filippo
 */
class SettlePaymentLinks(
        @SerializedName("payments:refund") val paymentCancel: PaymentsAction,
        @SerializedName("payments:partialRefund") val paymentSettle: PaymentsAction,
        @SerializedName("payments:events") val paymentEvents: PaymentsAction,
        curies : Array<Curie>
)