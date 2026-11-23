package az.ingress.task2;

public class SameDayDelivery implements DeliveryMethod {

    @Override
    public double price(DeliveryService.Order order) {
        return 15;
    }

    @Override
    public int days() {
        return 0;
    }

    @Override
    public String label() {
        return "Same day";
    }
}
