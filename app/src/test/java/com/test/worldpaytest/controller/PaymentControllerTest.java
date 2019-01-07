package com.test.worldpaytest.controller;

import com.test.worldpaytest.data.api.PaymentApi;
import com.test.worldpaytest.data.callback.PaymentCallback;
import com.test.worldpaytest.data.factory.PaymentFactory;
import com.test.worldpaytest.data.models.request.Payment;
import com.test.worldpaytest.data.models.response.PaymentResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import retrofit2.Call;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Filippo
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

    @Mock private PaymentCallback callback;
    @Mock private PaymentApi paymentApi;

    private PaymentController paymentController;

    @Before
    public void setUp() throws Exception {
        Call<PaymentResponse> call = mock(Call.class);//need to add Calls mock dependency
        when(paymentApi.authorizePayment(any(Payment.class))).thenReturn(call);
        this.paymentController = new PaymentController(paymentApi);
    }

    @Test
    public void test_paymentAuthorization() {
        Payment payment = PaymentFactory.createPayment("");
        this.paymentController.authorizePayment(payment, callback);
        verify(callback, times(1)).onSuccess();
    }

    @Test
    public void test_paymentCancellation() {
        this.paymentController.cancelPayment("", callback);
        verify(callback, times(1)).onSuccess();
    }

    @After
    public void tearDown() throws Exception {
        this.paymentController = null;
    }
}
