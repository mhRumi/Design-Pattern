package factoryMethod;

public class CheesePizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("Preparing CheesePizza");
    }

    @Override
    public void bake() {
        System.out.println("baking CheesePizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting CheesePizza");
    }

    @Override
    public void box() {
        System.out.println("boxing CheesePizza");
    }
}
