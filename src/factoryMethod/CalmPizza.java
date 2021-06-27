package factoryMethod;

public class CalmPizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("Preparing CalmPizza");
    }

    @Override
    public void bake() {
        System.out.println("baking CalmPizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting CalmPizza");
    }

    @Override
    public void box() {
        System.out.println("boxing CalmPizza");
    }
}
