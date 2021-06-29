package template;

public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Stepping the tea...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon...");
    }
}
