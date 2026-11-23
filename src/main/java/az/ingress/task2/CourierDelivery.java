package az.ingress.task2;

public class CourierDelivery implements DeliveryMethod {

    @Override
    public double price(DeliveryService.Order order) {
        if (order.total() >= 100) {
            return 0;
        }
        return 5 + order.weightKg() * 0.5;
    }

    @Override
    public int days() {
        return 2;
    }

    @Override
    public String label() {
        return "Courier";
    }
}
