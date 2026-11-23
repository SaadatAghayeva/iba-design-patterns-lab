package az.ingress.task1;

import java.util.Set;

public class BlacklistCheck extends ApplicationCheck {

    private final Set<String> blacklist;

    public BlacklistCheck(Set<String> blacklist) {
        this.blacklist = blacklist;
    }

    @Override
    public String check(LoanService.Application app) {
        if (blacklist.contains(app.name())) {
            return "REJECTED: blacklist";
        }
        return checkNext(app);
    }
}
