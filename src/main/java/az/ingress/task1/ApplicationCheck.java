package az.ingress.task1;

public abstract class ApplicationCheck {

    private ApplicationCheck next;

    public void setNext(ApplicationCheck next) {
        this.next = next;
    }

    public abstract String check(LoanService.Application app);

    protected String checkNext(LoanService.Application app) {
        if (next == null) {
            return "APPROVED";
        }
        return next.check(app);
    }
}
