package abhi.java.code.design_Patterns.TemplateMethod;

public abstract class PaymentFlow {

    public abstract void validatedRequest();
    public abstract void calculateFee();
    public abstract void debitAmount();
    public abstract void creditAmount();

    // This is template method which defines the order of steps to excute the task
    public final void sendMoney(){

        validatedRequest();
        calculateFee();
        debitAmount();
        creditAmount();

    }
}
