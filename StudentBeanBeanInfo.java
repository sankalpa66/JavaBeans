import java.beans.*; 
public class StudentBeanBeanInfo extends SimpleBeanInfo { 
public PropertyDescriptor[] getPropertyDescriptors() { 
try { 
PropertyDescriptor name = new PropertyDescriptor("name", StudentBean.class); 
name.setShortDescription("Name of the student"); 
PropertyDescriptor age = new PropertyDescriptor("age", StudentBean.class); 
age.setShortDescription("Age of the student"); 
return new PropertyDescriptor[] { name, age }; 
} catch (Exception e) { 
return null; 
} 
} 
} 