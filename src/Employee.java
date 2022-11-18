public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private static int count;

    public Employee(){
        this("Not Given","Not Given");
    }

    public Employee(String firstName, String lastName){
        incrementCount();
        setStaffID(count);
        setFirstName(firstName);
        setLastName(lastName);

    }
    public static void incrementCount(){
        count++;
    }
    public void setStaffID(int id){
        this.id = id;
    }
    public int getStaffID(){
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee Details: \n\n" +
                "Staff ID: "+ getStaffID() +
                "\nFirst Name: "+getFirstName() +
                "\nLast Name: "+getLastName();
    }
}
