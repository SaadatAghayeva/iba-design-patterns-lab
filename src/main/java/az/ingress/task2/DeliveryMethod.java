package az.ingress.task2;

public interface DeliveryMethod {

    double price(DeliveryService.Order order);

    int days();

    String label();
}
