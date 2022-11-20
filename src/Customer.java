import java.io.Serializable;
import java.util.GregorianCalendar;
//Customer.java

/**
 * An instantiable class which defines a Customer
 * @author Alan Ligman
 */
public class Customer implements Serializable {
    private String firstName;
    private String surname;
    private String emailAddress;
    private String address;
    private String phoneNumber;
    private String dateOfBirth;
    private String password;

    public Customer(){
        this("Not Specified", "Not Specified","Not Specified","Not Specified","Not Specified",null,"Not specified");
    }

    public Customer(String firstName, String surname, String emailAddress, String address,String phoneNumber, String dateOfBirth, String password) {
        setFirstName(firstName);
        setSurname(surname);
        setEmailAddress(emailAddress);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setDateOfBirth(dateOfBirth);
        setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer Details: \n\n" +
                "First name: "+getFirstName() +
                "\nLast name: "+getSurname() +
                "\nEmail Address: "+getEmailAddress() +
                "\nAddress: "+getAddress() +
                "\nPhone Number: "+getPhoneNumber() +
                "\nDate of Birth: "+getDateOfBirth() +
                "\nPassword: "+getPassword();
    }
}
