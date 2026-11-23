package az.ingress.task1;

public class CreditScoreCheck extends ApplicationCheck {

    private final CreditBureau creditBureau;

    public CreditScoreCheck(CreditBureau creditBureau) {
        this.creditBureau = creditBureau;
    }

    @Override
    public String check(LoanService.Application app) {
        if (creditBureau.getCreditScore(app.name()) < 600) {
            return "REJECTED: credit score";
        }
        return checkNext(app);
    }
}
