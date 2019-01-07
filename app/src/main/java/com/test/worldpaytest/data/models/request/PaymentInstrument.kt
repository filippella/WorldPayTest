package com.test.worldpaytest.data.models.request

/**
 * @author Filippo
 */
class PaymentInstrument(
        cvc : String,
        type : String,
        cardNumber : String,
        cardHolderName : String,
        billingAddress: BillingAddress,
        cardExpiryDate: CardExpiryDate
)