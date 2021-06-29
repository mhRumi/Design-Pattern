package state;

public class GreenLight implements State{
    TrafficSystem trafficSystem;

    public GreenLight(TrafficSystem trafficSystem) {
        this.trafficSystem = trafficSystem;
    }

    @Override
    public void onGreenLight() {
        System.out.println("Moving...");
    }

    @Override
    public void onYellowLight() {
        System.out.println("Move carefully...");
        trafficSystem.setState(trafficSystem.getYellowState());
    }

    @Override
    public void onRedLight() {
        System.out.println("Can't go from Green to Red");
    }
}
