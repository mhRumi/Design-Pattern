package state;

public interface State {
    public void onGreenLight();
    public void onYellowLight();
    public void onRedLight();
}
