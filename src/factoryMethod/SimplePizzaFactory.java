package factoryMethod;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type.equalsIgnoreCase("cheese")){
            pizza = new CheesePizza();
        }else if(type.equalsIgnoreCase("pepperoni"))
        {
            pizza = new PepperoniPizza();
        }else if(type.equalsIgnoreCase("calm")){
            pizza = new CheesePizza();
        }

        return pizza;
    }
}
