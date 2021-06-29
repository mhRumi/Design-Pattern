package template;

public class CaffeineHouse {
    public static void main(String[] args) {
        Tea tea = new Tea();
        System.out.println("---------making tea------------");
        tea.prepareRecipe();
        Coffee coffee = new Coffee();
        System.out.println("---------making coffee------------");
        coffee.prepareRecipe();
    }
}
