import java.util.EventObject; 
public class TemperatureEvent extends EventObject { 
private int temperature; 
public TemperatureEvent(Object source, int temperature) { 
super(source); 
this.temperature = temperature; 
} 
public int getTemperature() { return temperature; } 
} 