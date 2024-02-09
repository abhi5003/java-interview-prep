package abhi.java.code.design_Patterns.TemplateMethod;

public class PayToMerchent extends PaymentFlow{
    @Override
    public void validatedRequest() {

        // Specific validation for pay to friend
        System.out.println("Validate logic of pay to merchent");

    }

    @Override
    public void calculateFee() {

        System.out.println();
    }

    @Override
    public void debitAmount() {

        // Debit amount
        System.out.println("Debit amount logic to pay to merchent");
    }

    @Override
    public void creditAmount() {

        System.out.println();
    }
}
