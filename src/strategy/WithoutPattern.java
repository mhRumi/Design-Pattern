package strategy;

public class WithoutPattern {

    public double executeCalculation(String type,double a,double b)
    {
        if(type.equalsIgnoreCase("addition")){
            return add(a, b);
        }else if(type.equalsIgnoreCase("subtraction")){
            return subtract(a, b);
        }else if(type.equalsIgnoreCase("multiplication")){
            return muliply(a, b);
        }else if(type.equalsIgnoreCase("devision")){
            return devide(a, b);
        }
        return 1;
    }

    public double add(double a, double b)
    {
        return  a + b;
    }

    public double subtract(double a, double b)
    {
        return a - b;
    }

    public double muliply(double a, double b)
    {
        return a * b;
    }

    public double devide(double a, double b)
    {
        return a/b;
    }
}
