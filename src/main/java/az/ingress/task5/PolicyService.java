package az.ingress.task5;

public class PolicyService {

    static class Policy {
        private final String policyNo;
        private final String plate;
        private final String ownerName;
        private final double price;
        private final String driverName;
        private final boolean glassCover;
        private final boolean theftCover;
        private final boolean roadAssistance;
        private final String discountCode;
        private final int durationMonths;
        private final String email;

        private Policy(Builder builder) {
            this.policyNo = builder.policyNo;
            this.plate = builder.plate;
            this.ownerName = builder.ownerName;
            this.price = builder.price;
            this.driverName = builder.driverName;
            this.glassCover = builder.glassCover;
            this.theftCover = builder.theftCover;
            this.roadAssistance = builder.roadAssistance;
            this.discountCode = builder.discountCode;
            this.durationMonths = builder.durationMonths;
            this.email = builder.email;
        }

        @Override
        public String toString() {
            return policyNo + ": " + plate + ", " + ownerName + ", " + price + " AZN"
                    + (driverName != null ? ", driver " + driverName : "")
                    + (glassCover ? ", glass" : "")
                    + (theftCover ? ", theft" : "")
                    + (roadAssistance ? ", road assistance" : "")
                    + (discountCode != null ? ", discount " + discountCode : "")
                    + (durationMonths != 12 ? ", " + durationMonths + " months" : "")
                    + (email != null ? ", email " + email : "");
        }

        static class Builder {
            private String policyNo;
            private String plate;
            private String ownerName;
            private double price;
            private String driverName;
            private boolean glassCover;
            private boolean theftCover;
            private boolean roadAssistance;
            private String discountCode;
            private int durationMonths = 12;
            private String email;

            public Builder withPolicyNo(String policyNo) {
                this.policyNo = policyNo;
                return this;
            }

            public Builder withPlate(String plate) {
                this.plate = plate;
                return this;
            }

            public Builder withOwnerName(String ownerName) {
                this.ownerName = ownerName;
                return this;
            }

            public Builder withPrice(double price) {
                this.price = price;
                return this;
            }

            public Builder withDriver(String driverName) {
                this.driverName = driverName;
                return this;
            }

            public Builder withGlassCover() {
                this.glassCover = true;
                return this;
            }

            public Builder withTheftCover() {
                this.theftCover = true;
                return this;
            }

            public Builder withRoadAssistance() {
                this.roadAssistance = true;
                return this;
            }

            public Builder withDiscountCode(String discountCode) {
                this.discountCode = discountCode;
                return this;
            }

            public Builder withDurationMonths(int durationMonths) {
                this.durationMonths = durationMonths;
                return this;
            }

            public Builder withEmail(String email) {
                this.email = email;
                return this;
            }

            public Policy build() {
                if (policyNo == null) {
                    throw new IllegalStateException("policyNo is required");
                }
                if (plate == null) {
                    throw new IllegalStateException("plate is required");
                }
                if (ownerName == null) {
                    throw new IllegalStateException("ownerName is required");
                }
                if (price <= 0) {
                    throw new IllegalStateException("price must be positive");
                }
                return new Policy(this);
            }
        }
    }

    public static void main(String[] args) {
        Policy basic = new Policy.Builder()
                .withPolicyNo("P-1")
                .withPlate("10-AA-111")
                .withOwnerName("Aysel Mammadova")
                .withPrice(50)
                .build();

        Policy withDriver = new Policy.Builder()
                .withPolicyNo("P-2")
                .withPlate("90-BB-222")
                .withOwnerName("Murad Aliyev")
                .withPrice(50)
                .withDriver("Leyla Aliyeva")
                .build();

        Policy full = new Policy.Builder()
                .withPolicyNo("P-3")
                .withPlate("77-CC-333")
                .withOwnerName("Kamran Ismayilov")
                .withPrice(50)
                .withGlassCover()
                .withRoadAssistance()
                .withDiscountCode("SPRING10")
                .build();

        Policy sixMonths = new Policy.Builder()
                .withPolicyNo("P-4")
                .withPlate("10-DD-444")
                .withOwnerName("Nigar Guliyeva")
                .withPrice(30)
                .withTheftCover()
                .withDurationMonths(6)
                .withEmail("nigar@mail.az")
                .build();

        System.out.println(basic);
        System.out.println(withDriver);
        System.out.println(full);
        System.out.println(sixMonths);

        try {
            Policy noPlate = new Policy.Builder()
                    .withPolicyNo("P-5")
                    .withOwnerName("Elvin Babayev")
                    .withPrice(50)
                    .build();
            System.out.println(noPlate);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
