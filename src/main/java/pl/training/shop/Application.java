package pl.training.shop;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.training.shop.payments.*;

@Log
public class Application {

    private static final String BASE_PAACKAGE = "pl.training.shop";

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PAACKAGE)) {
            var paymentService = applicationContext.getBean(PaymentService.class);
            var paymentRequest = PaymentRequest.builder()
                    .money(LocalMoney.of(1000))
                    .build();
            var payment = paymentService.process(paymentRequest);
            log.info(payment.toString());
        }

    }
}
