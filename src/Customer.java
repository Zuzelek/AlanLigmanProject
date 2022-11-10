import java.util.GregorianCalendar;

public class Customer {
    private String firstName;
    private String surname;
    private String emailAddress;
    private int houseNumber;
    private String street;
    private String city;
    private String county;
    private String eircode;
    private String phoneNumber;
    private GregorianCalendar dateOfBirth;
    private String password;

    public Customer(){
        this("Not Specified", "Not Specified","Not Specified",0,"Not Specified","Not Specified","Not Specified","Not Specified","Not Specified",null,"Not Specified");
    }

    public Customer(String firstName, String surname, String emailAddress, int houseNumber, String street, String city, String county, String eircode, String phoneNumber, GregorianCalendar dateOfBirth, String password) {
        setFirstName(firstName);
        setSurname(surname);
        setEmailAddress(emailAddress);
        setHouseNumber(houseNumber);
        setStreet(street);
        setCity(city);
        setCounty(county);
        setEircode(eircode);
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

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
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
                "\nHouse number: "+getHouseNumber() +
                "\nStreet: "+getStreet() +
                "\nCity: "+getCity() +
                "\nCounty: "+getCounty() +
                "\nEircode: "+getEircode() +
                "\nPhone Number: "+getPhoneNumber() +
                "\nDate of Birth: "+getDateOfBirth() +
                "\nPassword: "+getPassword();
    }
}
