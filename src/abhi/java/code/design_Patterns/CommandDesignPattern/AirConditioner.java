package abhi.java.code.design_Patterns.CommandDesignPattern;

public class AirConditioner {

    boolean isOn;
    int temprature;

    public void turnOnAC(){
        isOn=true;
        System.out.println("AC is On");
    }

    public void turnOffAC(){
        isOn=false;
        System.out.println("AC is Off");
    }

    public void setTemprature(int temprature){
        this.temprature=temprature;
        System.out.println("Temprature chnage to" + temprature);
    }
}
