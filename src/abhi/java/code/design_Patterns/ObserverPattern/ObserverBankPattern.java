package abhi.java.code.design_Patterns.ObserverPattern;

public class ObserverBankPattern {
    public static void main(String[] args) {
        BankClient01 bankClient01 = new BankClient01();
        BankClient02 bankClient02 = new BankClient02();
        BankClient03 bankClient03 = new BankClient03();

        Subject subject = new Subject();
        subject.register(bankClient01);
        subject.register(bankClient02);
        subject.register(bankClient03);

        Message message1 = new Message();
        message1.setContent("Reduse loan rate by 1% today onwards");
        subject.setLoanDetails(message1);

        Message message2 = new Message();
        message2.setContent("Intoduscing new housing loan for professional");
        subject.setLoanDetails(message2);
    }
}
