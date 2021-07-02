package state;

public class TrafficSystemWithoutPattern {
    boolean green;
    boolean yellow;
    boolean red;

    public TrafficSystemWithoutPattern() {
        green = true;
        yellow= false;
        red = false;
    }

    public void driveCar(){
        if(green)
        {
            System.out.println("Car is running...");
        }else if(yellow){
            System.out.println("move slowly.");
        }else if(red){
            System.out.println("Wait until green light is on");
        }
    }

    public void greenLightOn(){
        green = true;
        yellow = false;
        red = false;
    }

    public void yellowLightOn(){
        yellow = true;
        green = false;
        red = false;
    }

    public void redLightOn(){
        green = false;
        yellow = false;
        red = true;
    }
}
