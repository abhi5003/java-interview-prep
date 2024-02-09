package abhi.java.code.design_Patterns.DecoratorPattern;

public class Mushroom extends ToppingDecorator{

    // Has-a relationship
    BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
