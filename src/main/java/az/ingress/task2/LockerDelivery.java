package az.ingress.task2;

public class LockerDelivery implements DeliveryMethod {

    @Override
    public double price(DeliveryService.Order order) {
        if (order.total() >= 50) {
            return 0;
        }
        return 3;
    }

    @Override
    public int days() {
        return 2;
    }

    @Override
    public String label() {
        return "Parcel locker";
    }
}
