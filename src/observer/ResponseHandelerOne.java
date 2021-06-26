package observer;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandelerOne implements Observer {
    private String resp;
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String){
            resp = (String) arg;
            System.out.println("Received response: "+resp);
        }
    }
}
