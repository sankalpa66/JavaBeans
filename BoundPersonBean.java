import java.beans.*; 
import java.io.Serializable; 
public class BoundPersonBean implements Serializable { 
private String name; 
private PropertyChangeSupport pcs = new PropertyChangeSupport(this); 
public BoundPersonBean() {} 
public void addPropertyChangeListener(PropertyChangeListener listener) { 
pcs.addPropertyChangeListener(listener); 
} 
public String getName() { return name; } 
public void setName(String newName) { 
String old = this.name; 
this.name = newName; 
pcs.firePropertyChange("name", old, newName); 
} 
} 