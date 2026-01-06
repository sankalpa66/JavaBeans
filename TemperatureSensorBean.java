import java.util.*; 
public class TemperatureSensorBean { 
private List<TemperatureListener> listeners = new ArrayList<>(); 
private int temperature; 
public void addTemperatureListener(TemperatureListener l) { 
listeners.add(l); 
} 
public void setTemperature(int t) { 
this.temperature = t; 
TemperatureEvent e = new TemperatureEvent(this, t); 
for (TemperatureListener l : listeners) { 
l.temperatureChanged(e); 
} 
} 
}