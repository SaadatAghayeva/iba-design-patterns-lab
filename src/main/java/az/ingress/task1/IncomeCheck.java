package az.ingress.task1;

public class IncomeCheck extends ApplicationCheck {

    @Override
    public String check(LoanService.Application app) {
        if (app.amount() > app.salary() * 10) {
            return "REJECTED: income";
        }
        return checkNext(app);
    }
}
