import java.beans.*; 
public class ConstrainedAccountBean { 
private double balance; 
private VetoableChangeSupport vcs = new VetoableChangeSupport(this); 
public void addVetoableChangeListener(VetoableChangeListener l) { 
vcs.addVetoableChangeListener(l); 
} 
public double getBalance() { return balance; } 
public void setBalance(double newBalance) throws PropertyVetoException { 
double old = balance; 
vcs.fireVetoableChange("balance", old, newBalance); 
this.balance = newBalance; 
} 
} 