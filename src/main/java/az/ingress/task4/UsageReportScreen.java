package az.ingress.task4;

public class UsageReportScreen {

    record User(String name, String phone, boolean operator) {
    }

    interface UsageReports {
        String getReport(String phone);
    }

    static class BillingSystem implements UsageReports {
        static int connections = 0;
        static int requests = 0;

        BillingSystem() {
            connections++;
            System.out.println("   [billing] connecting...");
        }

        public String getReport(String phone) {
            requests++;
            return phone + ": 12.4 GB, 340 min, 25 SMS";
        }
    }

    private final User user;
    private final UsageReports reports;

    UsageReportScreen(User user) {
        this.user = user;
        this.reports = new UsageReportsProxy(user);
    }

    public void showReport(String phone) {
        System.out.println(user.name() + " -> " + reports.getReport(phone));
    }

    public static void main(String[] args) {
        UsageReportScreen aysel = new UsageReportScreen(new User("Aysel", "050-111-11-11", false));
        aysel.showReport("050-111-11-11");
        aysel.showReport("050-222-22-22");
        aysel.showReport("050-111-11-11");

        UsageReportScreen operator = new UsageReportScreen(new User("Operator", "-", true));
        operator.showReport("050-222-22-22");

        UsageReportScreen murad = new UsageReportScreen(new User("Murad", "050-333-33-33", false));

        UsageReportScreen leyla = new UsageReportScreen(new User("Leyla", "050-444-44-44", false));
        leyla.showReport("050-111-11-11");

        System.out.println("Billing connections: " + BillingSystem.connections + ", requests: " + BillingSystem.requests);
    }
}
