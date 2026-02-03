package abhi.java.code.design_Patterns.ObserverPattern;

public class BankClient03 implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("Observer Bank Client 03: "+ message.getContent());
    }
}
