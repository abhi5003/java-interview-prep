package abhi.java.code.design_Patterns.DecoratorPattern;

public class ExtraCheese extends ToppingDecorator{

    // Has a relationship
    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
