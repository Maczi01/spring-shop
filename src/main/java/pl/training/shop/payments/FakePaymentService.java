package pl.training.shop.payments;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class FakePaymentService implements PaymentService {

    private final PaymentIdGenerator paymentIdGenerator;

    @LogPayments
    @Override
    public Payment process(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(paymentIdGenerator.getNext())
                .money(paymentRequest.getMoney())
                .time(Instant.now())
                .status(PaymentStatus.STARTED)
                .build();
    }


}
