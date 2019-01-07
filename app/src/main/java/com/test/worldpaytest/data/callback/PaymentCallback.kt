package com.test.worldpaytest.data.callback

/**
 * @author Filippo
 */
interface PaymentCallback {

    fun onSuccess()

    fun onError()
}