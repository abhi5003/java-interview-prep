package abhi.java.code.design_Patterns.CommandDesignPattern;

public class TurnACOffCommand implements ICommand{

    AirConditioner ac;
    public TurnACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }


    @Override
    public void excute() {
       ac.turnOffAC();
    }

    @Override
    public void undo() {
       ac.turnOnAC();
    }
}
