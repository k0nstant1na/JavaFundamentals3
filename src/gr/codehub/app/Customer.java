package gr.codehub.app;

public class Customer {
    private String code;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer() {

    }

    public Customer(String code, String name, String surname, String phone, String address, String email) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
