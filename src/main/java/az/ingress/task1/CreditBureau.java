package az.ingress.task1;

import java.util.Map;

public class CreditBureau {

    private final Map<String, Integer> scores = Map.of(
            "Aysel Mammadova", 720, "Leyla Hasanova", 640, "Kamran Ismayilov", 580,
            "Nigar Guliyeva", 760, "Sabina Karimova", 750);
    private int paidRequests = 0;

    public int getCreditScore(String name) {
        paidRequests++;
        return scores.getOrDefault(name, 0);
    }

    public int getPaidRequests() {
        return paidRequests;
    }
}
