package abhi.java.code.design_Patterns.Adopter.Client;


import abhi.java.code.design_Patterns.Adopter.Adaptee.WeightMachineForBabies;
import abhi.java.code.design_Patterns.Adopter.Adaptor.WeightMachineAdapter;
import abhi.java.code.design_Patterns.Adopter.Adaptor.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
