package az.ingress.task4;

public class UsageReportsProxy implements UsageReportScreen.UsageReports {

    private final UsageReportScreen.User user;
    private UsageReportScreen.BillingSystem billingSystem;

    public UsageReportsProxy(UsageReportScreen.User user) {
        this.user = user;
    }

    @Override
    public String getReport(String phone) {
        if (!user.operator() && !user.phone().equals(phone)) {
            return "ACCESS DENIED";
        }
        if (billingSystem == null) {
            billingSystem = new UsageReportScreen.BillingSystem();
        }
        return billingSystem.getReport(phone);
    }
}
