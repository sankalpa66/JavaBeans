import java.beans.PropertyVetoException;

public class TestAllBeans { 
    public static void main(String[] args) { 
    try { 
    System.out.println("=== Simple Bean Test ==="); 
    StudentBean s = new StudentBean(); 
    s.setName("Ram"); 
    s.setAge(21); 
    System.out.println(s.getName() + " - " + s.getAge()); 
    System.out.println("\n=== Bound Property Test ==="); 
    BoundPersonBean p = new BoundPersonBean(); 
    p.addPropertyChangeListener(evt -> { 
    System.out.println("Old: " + evt.getOldValue()); 
    System.out.println("New: " + evt.getNewValue()); 
    }); 
    p.setName("Hari"); 
    p.setName("Shyam"); 
    System.out.println("\n=== Constrained Property Test ==="); 
    ConstrainedAccountBean acc = new ConstrainedAccountBean(); 
    acc.addVetoableChangeListener(evt -> { 
    if ((double) evt.getNewValue() < 0) 
    throw new PropertyVetoException("Negative balance not allowed!", evt); 
    }); 
    try { 
    acc.setBalance(-500); 
    } catch (Exception e) { 
    System.out.println("Veto: " + e.getMessage()); 
    } 
    System.out.println("\n=== Custom Event Test ==="); 
    TemperatureSensorBean ts = new TemperatureSensorBean(); 
    ts.addTemperatureListener(e -> System.out.println("Temperature changed: " + e.getTemperature())); 
    ts.setTemperature(40); 
    ts.setTemperature(60); 
    System.out.println("\n=== Persistence Test ==="); 
    BeanPersistence.save(s, "student.dat"); 
    StudentBean loaded = (StudentBean) BeanPersistence.load("student.dat"); 
    System.out.println("Loaded Name: " + loaded.getName()); 
    } catch (Exception e) { 
    e.printStackTrace(); 
    } 
    } 
    }