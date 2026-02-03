package abhi.java.code.design_Patterns.ObserverPattern;

public class BankClient02 implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("Observer Bank Client 02: "+ message.getContent());
    }
}
