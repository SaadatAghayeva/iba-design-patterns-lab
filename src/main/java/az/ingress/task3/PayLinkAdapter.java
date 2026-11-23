package az.ingress.task3;

public class PayLinkAdapter implements PaymentService.PaymentGateway {

    private final PaymentService.PayLinkSdk sdk = new PaymentService.PayLinkSdk();

    @Override
    public boolean pay(String card, double amountAzn) {
        long qapik = Math.round(amountAzn * 100);
        int code = sdk.charge(card, qapik);
        return code == 0;
    }
}
