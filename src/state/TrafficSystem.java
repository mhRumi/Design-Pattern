package state;

public class TrafficSystem {
    State green;
    State yellow;
    State red;

    State state;

    public TrafficSystem()
    {
        green = new GreenLight(this);
        yellow = new YellowLight(this);
        red = new RedLight(this);

        state = green;
    }

    public void turnOnGreenLight(){
        state.onGreenLight();
    }

    public void turnOnYellowLight(){
        state.onYellowLight();
    }

    public void turnOnRedLight(){
        state.onRedLight();
    }

    void setState(State state){
        this.state = state;
    }

    public State getGreenState(){
        return green ;
    }

    public State getYellowState(){
        return yellow;
    }
    public State getRedState(){
        return red;
    }
}
