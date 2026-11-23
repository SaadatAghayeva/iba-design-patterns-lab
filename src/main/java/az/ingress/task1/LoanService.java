package az.ingress.task1;

import java.util.List;
import java.util.Set;

public class LoanService {

    record Application(String name, int age, int monthsAtJob, double salary, double amount) {
    }

    private final Set<String> blacklist = Set.of("Rashad Huseynov");
    private final Set<String> sanctions = Set.of("Ivan Petrov");
    private final CreditBureau creditBureau = new CreditBureau();
    private final ApplicationCheck firstCheck;

    public LoanService() {
        ApplicationCheck sanctionsCheck = new SanctionsCheck(sanctions);
        ApplicationCheck ageCheck = new AgeCheck();
        ApplicationCheck workExperienceCheck = new WorkExperienceCheck();
        ApplicationCheck blacklistCheck = new BlacklistCheck(blacklist);
        ApplicationCheck incomeCheck = new IncomeCheck();
        ApplicationCheck creditScoreCheck = new CreditScoreCheck(creditBureau);

        sanctionsCheck.setNext(ageCheck);
        ageCheck.setNext(workExperienceCheck);
        workExperienceCheck.setNext(blacklistCheck);
        blacklistCheck.setNext(incomeCheck);
        incomeCheck.setNext(creditScoreCheck);

        firstCheck = sanctionsCheck;
    }

    public String evaluate(Application app) {
        return firstCheck.check(app);
    }

    public static void main(String[] args) {
        LoanService service = new LoanService();

        List<Application> applications = List.of(
                new Application("Aysel Mammadova", 30, 24, 2000, 10000),
                new Application("Murad Aliyev", 17, 6, 800, 2000),
                new Application("Rashad Huseynov", 40, 48, 3000, 5000),
                new Application("Leyla Hasanova", 35, 36, 1000, 15000),
                new Application("Kamran Ismayilov", 45, 60, 3000, 20000),
                new Application("Nigar Guliyeva", 28, 12, 4000, 30000),
                new Application("Ivan Petrov", 39, 24, 3000, 5000),
                new Application("Farid Mammadli", 33, 3, 5000, 10000),
                new Application("Sabina Karimova", 31, 12, 2500, 20000)
        );

        for (Application app : applications) {
            System.out.println(app.name() + " -> " + service.evaluate(app));
        }
        System.out.println("Paid credit bureau requests: " + service.creditBureau.getPaidRequests());
    }
}
