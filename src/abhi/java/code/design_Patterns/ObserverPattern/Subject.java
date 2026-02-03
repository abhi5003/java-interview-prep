package abhi.java.code.design_Patterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private Message message;

    public void register(Observer observer){
        observers.add(observer);
    }

    public void unregister(Observer observer){
        observers.remove(observer);
    }

    public void setLoanDetails(Message message){
        notifyAll(message);
    }

    private void notifyAll(Message message) {
        for(Observer o : observers){
            o.update(message);
        }
    }
}
