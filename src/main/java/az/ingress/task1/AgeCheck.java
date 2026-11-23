package az.ingress.task1;

public class AgeCheck extends ApplicationCheck {

    @Override
    public String check(LoanService.Application app) {
        if (app.age() < 18 || app.age() > 65) {
            return "REJECTED: age";
        }
        return checkNext(app);
    }
}
