# Problem

<h3>
    The three players in the system are the weather station (the physical device
    that acquires the actual weather data), the WeatherData object (that tracks the
    data coming from the Weather Station and updates the displays), and the
    display that shows users the current weather conditions.
  </h3>

# Let's dive into coding...

```java
  public class WeatherData{
    
    public void measurementChanged(){
      float temp = getTemperature();
      float humidity = getHumidity();
      float pressure = getPressure();
      
      currentConditionsDisplay.update(temp, humidity, pressure);
      statisticsDisplay.update(temp, humidity, pressure);
      forecastDisplay.update(temp, humidity, pressure);
    }
    
    // other methods here
  }
```

<h2> But does our implementation following Design principles? </h1>
<ol>
  <li> We are coding to concrete implementations, not interfaces. </li>
  <li> For every new display element we need to alter code. </li>
  <li> We have no way to add (or remove) display elements at run time. </li>
  <li> The display elements don’t implement a common interface. </li>
  <li> We haven’t encapsulated the part that changes. </li>
  <li> We are violating encapsulation of the WeatherData class. </li>
</ol>

# Meet the Observer Pattern
We will follow **Observer** design pattern to overcome those situations.
<h3>
But at first we have to know how newspaper or magazine subsciptions work:</h3>
<ol>
  <li> A newspaper publisher goes into business and begins publishingnewspapers. </li>
  <li> You subscribe to a particular publisher, and every time there’s a new
      edition it gets delivered to you. As long as you remain a subscriber, you
      get new newspapers. </li>
  <li> You unsubscribe when you don’t want papers anymore, and they stop being delivered. </li>
  <li> While the publisher remains in business, people, hotels, airlines, and other businesses constantly subscribe and unsubscribe to the newspaper. </li>
  </ol>
  
  # Implementation
  As Design principles says code to interface not to implementation. So we are going to create an interface called Subject
  
  Observers will observe(listen) to this subject and will be notified when something change or update
  ```java
  public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
  ```
 The Observer observe Subject and will be notified when subject get any update 
```java
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
```
 Display update info 
```java
public interface DisplalyElement {
    public void display();
}
```

Now let's implement Subject 

```java

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData()
    {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers)
        {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeaseurements(float temperature, float humidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}

```

Now, Let's build those display elements. Here **CurrentConditionsDisplay** implements **Observer** and **DisplayElement**. **Observer** will notified if any update 
received by our Subject and this info will be render by displayElement that's why **CurrentConditionsDisplay** is implementing both of them.

```java

public class CurrentConditionsDisplay implements Observer, DisplalyElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Temperature: "+temperature+" Humidity: "+humidity+ "  Pressure:  "+pressure);
    }

}

```

# Now, let's create a driver class

```java

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeaseurements(80, 65, 30.4f);
        weatherData.setMeaseurements(80, 70, 29.2f);
        weatherData.setMeaseurements(70, 45, 40.4f);
    }
}

```
Display will pritn or render this
```
Temperature: 80.0 Humidity: 65.0  Pressure:  0.0
Temperature: 80.0 Humidity: 70.0  Pressure:  0.0
Temperature: 70.0 Humidity: 45.0  Pressure:  0.0

```

