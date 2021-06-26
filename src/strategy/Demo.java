package strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter first number: ");
        float num1 = Float.parseFloat(bufferedReader.readLine());
        System.out.print("Please enter second number: ");
        float num2 = Float.parseFloat(bufferedReader.readLine());
        Context context = new Context(new Addition());
        System.out.println("Addition: "+context.executeStrategy(num1, num2));

        context = new Context(new Substraction());
        System.out.println("Substraction: "+context.executeStrategy(num1, num2));

        context = new Context(new Multiplication());
        System.out.println("Multiplication: "+context.executeStrategy(num1, num2));
    }
}
