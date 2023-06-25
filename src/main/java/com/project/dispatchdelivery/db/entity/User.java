package com.project.dispatchdelivery.db.entity;





public class User {
    private String UID;
    private String firstName;
    private String lastName;

    private String email;
    private String phone;

//    public UsersEntity ToUsersEntity() {
//        UsersEntity customer = new UsersEntity();
//        customer.setEmailAddress(this.email);
//        customer.setLastName(this.lastName);
//        customer.setFirstName(this.firstName);
//        customer.setPhoneNumber(this.phone);
//        return customer;
//    }


    public User () {

    }
    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(String UID) {
        this.UID = UID;
    }

    public User(String UID, String firstName, String lastName, String email, String phone) {
        this.UID = UID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
