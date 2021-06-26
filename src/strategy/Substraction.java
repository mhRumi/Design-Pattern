package strategy;

public class Substraction implements Strategy{
    @Override
    public float calculation(float a, float b) {
        return a-b;
    }
}
