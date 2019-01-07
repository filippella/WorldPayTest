package com.test.worldpaytest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.test.worldpaytest.R
import com.test.worldpaytest.controller.PaymentController
import com.test.worldpaytest.data.api.PaymentApi
import com.test.worldpaytest.data.callback.PaymentCallback
import com.test.worldpaytest.data.factory.PaymentFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var paymentController: PaymentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paymentApi : PaymentApi = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(PaymentApi.BASE_URL)
                .build()
                .create(PaymentApi::class.java)

        paymentController = PaymentController(paymentApi)
    }

    fun handlePaymentAuthorization(view: View) {
        showToast("Authorize payment!")
        val payment = PaymentFactory.createPayment("")
        paymentController.authorizePayment(payment, object : PaymentCallback {

            override fun onSuccess() {
                //TODO
            }

            override fun onError() {
                //TODO
            }
        })
    }

    private fun showToast(message: String?) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}
