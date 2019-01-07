package com.test.worldpaytest.controller

import com.test.worldpaytest.data.api.PaymentApi
import com.test.worldpaytest.data.callback.PaymentCallback
import com.test.worldpaytest.data.models.request.Payment
import com.test.worldpaytest.data.models.response.CancelPaymentResponse
import com.test.worldpaytest.data.models.response.PaymentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Filippo
 */
class PaymentController(private val paymentApi: PaymentApi) {

    private var processing: Boolean = false

    fun authorizePayment(payment: Payment, callback: PaymentCallback) : Boolean {
        if(processing) return false
        processing = true
        val authorizePayment = paymentApi.authorizePayment(payment)
        authorizePayment.enqueue(object : Callback<PaymentResponse> {

            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
                callback.onError()
                processing = false
            }

            override fun onResponse(call: Call<PaymentResponse>, response: Response<PaymentResponse>) {
                if (response.isSuccessful) {
                    val paymentResponse = response.body()
                    paymentResponse?.let {
                        callback.onSuccess()
                    } ?: kotlin.run {
                        callback.onError()
                    }
                } else {
                    callback.onError()
                }
                processing = false
            }
        })
        return true
    }

    fun cancelPayment(token: String, callback: PaymentCallback) : Boolean {
        if(processing) return false
        processing = true
        val cancelPayment = paymentApi.cancelPayment(token)
        cancelPayment.enqueue(object : Callback<CancelPaymentResponse> {

            override fun onFailure(call: Call<CancelPaymentResponse>, t: Throwable) {
                callback.onError()
                processing = false
            }

            override fun onResponse(call: Call<CancelPaymentResponse>, response: Response<CancelPaymentResponse>) {
                if (response.isSuccessful) {
                    val cancelResponse = response.body()
                    cancelResponse?.let {
                        callback.onSuccess()
                    } ?: kotlin.run {
                        callback.onError()
                    }
                } else {
                    callback.onError()
                }
                processing = false
            }
        })
        return true
    }
}
