package state;

public class YellowLight implements State{
    TrafficSystem trafficSystem;

    public YellowLight(TrafficSystem trafficSystem) {
        this.trafficSystem = trafficSystem;
    }

    @Override
    public void onGreenLight() {
        System.out.println("Can't go to Green from yellow");
    }

    @Override
    public void onYellowLight() {
        System.out.println("Yellow light already on");
    }

    @Override
    public void onRedLight() {
        System.out.println("Turning on red light...");
        trafficSystem.setState(trafficSystem.getRedState());
    }
}
