package az.ingress.task2;

import java.util.List;
import java.util.Map;

public class DeliveryService {

    record Order(String customer, double total, double weightKg, String deliveryType) {
    }

    private final Map<String, DeliveryMethod> methods = Map.of(
            "COURIER", new CourierDelivery(),
            "PICKUP", new PickupDelivery(),
            "EXPRESS", new ExpressDelivery(),
            "SAME_DAY", new SameDayDelivery(),
            "LOCKER", new LockerDelivery()
    );

    private DeliveryMethod getMethod(Order order) {
        DeliveryMethod method = methods.get(order.deliveryType());
        if (method == null) {
            throw new IllegalArgumentException("Unknown delivery type: " + order.deliveryType());
        }
        return method;
    }

    public double price(Order order) {
        return getMethod(order).price(order);
    }

    public int days(Order order) {
        return getMethod(order).days();
    }

    public String label(Order order) {
        return getMethod(order).label();
    }

    public String receipt(Order order) {
        return String.format("%s: %s, %.2f AZN, %d day(s)",
                order.customer(), label(order), price(order), days(order));
    }

    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();

        List<Order> orders = List.of(
                new Order("Aysel", 120, 3, "COURIER"),
                new Order("Murad", 40, 2, "COURIER"),
                new Order("Leyla", 30, 1, "PICKUP"),
                new Order("Kamran", 80, 4, "EXPRESS"),
                new Order("Nigar", 60, 1, "SAME_DAY"),
                new Order("Rashad", 70, 2, "LOCKER"),
                new Order("Elvin", 20, 1, "LOCKER"),
                new Order("Farid", 50, 1, "DRONE")
        );

        for (Order order : orders) {
            try {
                System.out.println(service.receipt(order));
            } catch (IllegalArgumentException e) {
                System.out.println(order.customer() + ": " + e.getMessage());
            }
        }
    }
}
