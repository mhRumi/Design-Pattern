package state;

public class RedLight implements State{
    TrafficSystem trafficSystem;

    public RedLight(TrafficSystem trafficSystem) {
        this.trafficSystem = trafficSystem;
    }

    @Override
    public void onGreenLight() {
        System.out.println("Going back to green...");
        trafficSystem.setState(trafficSystem.getGreenState());
    }

    @Override
    public void onYellowLight() {
        System.out.println("Can't go to yellow from red");
    }

    @Override
    public void onRedLight() {
        System.out.println("Red signal already on...");
    }
}
