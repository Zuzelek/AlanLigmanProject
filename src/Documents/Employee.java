package Documents;

import java.io.Serializable;
//Employee.java

/**
 * An instantiable class which defines an Employee.
 * @author Alan Ligman
 */
public class Employee implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private static int count;

    /**
     * Employee no-argument constructor. Calls the 2-argument Employee constructor to initialise the
     * attributes of Employee object with some default initial values to leave the Employee
     * object in a consistent initial state
     */
    public Employee(){
        this("Not Given","Not Given");
    }

    /**
     * Employee 2-argument constructor. Calls the 3 mutators and the incrementCount() method
     * to initialise the attributes of an Employee object with some user-supplied values. The Staff ID
     * is set internally using the value of the count attribute, to ensure a unique Staff ID values.
     * @param firstName the first name of employee
     * @param lastName the last name of employee
     */
    public Employee(String firstName, String lastName){
        incrementCount();
        setStaffID(count);
        setFirstName(firstName);
        setLastName(lastName);

    }

    /**
     * Method to increment the static count attribute of the class, this is to ensure that every
     * Employee object will have a unique ID value, as it tracks the value of this attribute
     */
    public static void incrementCount(){
        count++;
    }

    /**
     * Method to get the value of the static count attribute
     * @return an integer value specifying the current value of the count attribute
     */
    public int getStaffID(){
        return id;
    }

    /**
     * Method to get the first name of the Employee object
     * @return a String value specifying the First name of an Employee object
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Method to get the last name of the Employee object
     * @return a String value specifying the Last name of an Employee object
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Method to set the ID of an Employee object
     * @param id the number of the Employee
     */
    public void setStaffID(int id){
        this.id = id;
    }

    /**
     * Method to set the first name of an Employee Object
     * @param firstName the first name of the Employee
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method to set the last name of an Employee Object
     * @param lastName the last name of the Employee
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method to get the state of an Employee object
     * @return a String value specifying the state of an Employee Object
     */
    @Override
    public String toString() {
        return "Employee Details: \n\n" +
                "Staff ID: "+ getStaffID() +
                "\nFirst Name: "+getFirstName() +
                "\nLast Name: "+getLastName();
    }
}
