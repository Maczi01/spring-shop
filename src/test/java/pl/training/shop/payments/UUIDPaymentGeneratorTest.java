package pl.training.shop.payments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class UUIDPaymentGeneratorTest {


    private static final String ID_FORMAT = "\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}";

    private final UUIDPaymentIdGenerator uuidPaymentIdGenerator = new UUIDPaymentIdGenerator();

    @DisplayName("Should generate valid id")
    @Test
    void shouldGenerateValidID() {
        String idGeneratorNext = uuidPaymentIdGenerator.getNext();
        Assertions.assertTrue(idGeneratorNext.matches(ID_FORMAT));
    }

}
