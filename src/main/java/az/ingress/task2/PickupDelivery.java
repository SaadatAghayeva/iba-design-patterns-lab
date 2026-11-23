package az.ingress.task2;

public class PickupDelivery implements DeliveryMethod {

    @Override
    public double price(DeliveryService.Order order) {
        return 2;
    }

    @Override
    public int days() {
        return 3;
    }

    @Override
    public String label() {
        return "Pickup point";
    }
}
