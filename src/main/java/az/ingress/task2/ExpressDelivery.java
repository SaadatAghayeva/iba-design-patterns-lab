package az.ingress.task2;

public class ExpressDelivery implements DeliveryMethod {

    @Override
    public double price(DeliveryService.Order order) {
        return 10 + order.weightKg();
    }

    @Override
    public int days() {
        return 1;
    }

    @Override
    public String label() {
        return "Express";
    }
}
