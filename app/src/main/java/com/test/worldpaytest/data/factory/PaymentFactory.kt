package com.test.worldpaytest.data.factory

import com.test.worldpaytest.data.models.request.BillingAddress
import com.test.worldpaytest.data.models.request.CardExpiryDate
import com.test.worldpaytest.data.models.request.Instruction
import com.test.worldpaytest.data.models.request.Payment
import com.test.worldpaytest.data.models.request.PaymentInstrument
import com.test.worldpaytest.data.models.request.Value

/**
 * @author Filippo
 */
object PaymentFactory {

    @JvmStatic fun createPayment(transactionReference: String): Payment {
        return Payment(transactionReference, createInstruction())
    }

    private fun createInstruction(): Instruction {
        val value = Value("", 123.0)
        val billingAddress = BillingAddress(
                "", "", "", "", "", "", ""
        )
        val cardExpiryDate = CardExpiryDate(7, 2020)
        val paymentInstrument = PaymentInstrument(
                "", "", "", "", billingAddress,
                cardExpiryDate
        )
        return Instruction("", value, paymentInstrument)
    }
}
