package com.example.moviebooking2.model;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String password;
    private String verificationCode;
    private boolean isVerified;
    private String otp;
    private int roleId;
    private String role_name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole_name() {return role_name;}

    public void setRole_name(String role_name) {this.role_name = role_name;}

    public boolean isVerified() {
        return isVerified;
    }

    public String getOtp() {return otp;}

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public boolean setVerified(boolean verified) {return isVerified = verified;}

    public String getVerificationCode() {return verificationCode;}

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {return roleId;}

    public void setRoleId(int roleId) {this.roleId = roleId;}
}
