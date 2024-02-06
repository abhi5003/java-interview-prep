package abhi.java.code.design_Patterns.CommandDesignPattern;

public class Main {

    public static void main(String[] args) {

        AirConditioner airConditioner=new AirConditioner();
        MyRemoteControl remoteControl=new MyRemoteControl();

        remoteControl.setCommand(new TurnACOnCommand(airConditioner));
        remoteControl.pressButton();

        // Undo the last operation
        remoteControl.undo();

    }

}
