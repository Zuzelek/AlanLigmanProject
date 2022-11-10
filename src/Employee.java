public class Employee {
    private String firstName;
    private String lastName;

    public Employee(){
        this("Not Given","Not Given");
    }

    public Employee(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
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
                "First Name: "+getFirstName() +
                "Last Name: "+getLastName();
    }
}
