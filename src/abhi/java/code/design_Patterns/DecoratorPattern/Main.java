package abhi.java.code.design_Patterns.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        BasePizza farmHouse=new Mushroom(new ExtraCheese(new VegDelight()));
        System.out.println(farmHouse.cost());
    }
}
