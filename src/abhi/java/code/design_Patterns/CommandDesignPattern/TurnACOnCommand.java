package abhi.java.code.design_Patterns.CommandDesignPattern;

public class TurnACOnCommand implements ICommand{

    AirConditioner ac;
    public TurnACOnCommand(AirConditioner ac) {
        this.ac = ac;
    }


    @Override
    public void excute() {

        ac.turnOnAC();

    }

    @Override
    public void undo() {

        ac.turnOffAC();

    }
}
