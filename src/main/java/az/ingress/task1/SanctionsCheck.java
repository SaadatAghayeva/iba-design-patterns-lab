package az.ingress.task1;

import java.util.Set;

public class SanctionsCheck extends ApplicationCheck {

    private final Set<String> sanctions;

    public SanctionsCheck(Set<String> sanctions) {
        this.sanctions = sanctions;
    }

    @Override
    public String check(LoanService.Application app) {
        if (sanctions.contains(app.name())) {
            return "REJECTED: sanctions";
        }
        return checkNext(app);
    }
}
