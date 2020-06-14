package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class LoggingPaymentService implements PaymentService {

    private final FakePaymentService paymentService;
    private static final String LOG_FORMAT = "A payment of %s has been initializated";

    private String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var payment = paymentService.process(paymentRequest);
        log.info(createLogEntry(payment));
        return payment;
    }
}
