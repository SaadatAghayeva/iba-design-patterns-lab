package az.ingress.task3;

import java.math.BigDecimal;

public class EasyPayAdapter implements PaymentService.PaymentGateway {

    private final PaymentService.EasyPaySdk sdk = new PaymentService.EasyPaySdk();

    @Override
    public boolean pay(String card, double amountAzn) {
        try {
            sdk.makePayment(BigDecimal.valueOf(amountAzn), "AZN", card);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
