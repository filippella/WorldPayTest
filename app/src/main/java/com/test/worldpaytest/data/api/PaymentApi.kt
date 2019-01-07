package com.test.worldpaytest.data.api

import com.test.worldpaytest.data.models.request.PartiallySettlePayment
import com.test.worldpaytest.data.models.request.Payment
import com.test.worldpaytest.data.models.response.CancelPaymentResponse
import com.test.worldpaytest.data.models.response.PaymentResponse
import com.test.worldpaytest.data.models.response.SettlePaymentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * @author Filippo
 */
interface PaymentApi {

    companion object {
        const val BASE_URL = "https://access.worldpay.com"
    }

    @POST("/payments")
    fun authorizePayment(@Body payment: Payment) : Call<PaymentResponse>

    @POST("/payments/authorizations/cancellations/{token}")
    fun cancelPayment(@Path("token") token: String) : Call<CancelPaymentResponse>

    @POST("/payments/settlements/partials/{token}")
    fun settlePartialPayment(@Path("token") token: String, @Body partiallySettlePayment: PartiallySettlePayment) : Call<SettlePaymentResponse>

    @POST("/payments/settlements/full/{token}")
    fun settleFullPayment(@Path("token") token: String) : Call<SettlePaymentResponse>
}