package az.ingress.task3;

public class GlobalPayAdapter implements PaymentService.PaymentGateway {

    private final PaymentService.GlobalPaySdk sdk = new PaymentService.GlobalPaySdk();

    @Override
    public boolean pay(String card, double amountAzn) {
        double amountUsd = amountAzn / 1.70;
        String result = sdk.process(amountUsd, card);
        return result.equals("OK");
    }
}
