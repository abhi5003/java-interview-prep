package abhi.java.code.design_Patterns.ObserverPattern;

public class BankClient01 implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("Observer Bank Client 01: "+ message.getContent());
    }
}
