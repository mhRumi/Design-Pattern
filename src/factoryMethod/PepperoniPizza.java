package factoryMethod;

public class PepperoniPizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("Preparing PepperoniPizza");
    }

    @Override
    public void bake() {
        System.out.println("Preparing PepperoniPizza");
    }

    @Override
    public void cut() {
        System.out.println("Preparing PepperoniPizza");
    }

    @Override
    public void box() {
        System.out.println("Preparing PepperoniPizza");
    }
}
