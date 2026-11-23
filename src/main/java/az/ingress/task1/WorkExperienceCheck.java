package az.ingress.task1;

public class WorkExperienceCheck extends ApplicationCheck {

    @Override
    public String check(LoanService.Application app) {
        if (app.monthsAtJob() < 6) {
            return "REJECTED: work experience";
        }
        return checkNext(app);
    }
}
