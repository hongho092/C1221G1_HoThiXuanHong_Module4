package com.example.model;

public class Form {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String country;
    private String passportNumber;
    private String vehicle;
    private String vehicleCode;
    private String dayStart;
    private String dayEnd;
    private String note;

    public Form() {
    }

    public Form(String name, String dateOfBirth, String gender, String country, String passportNumber, String vehicle, String vehicleCode, String dayStart, String dayEnd, String note) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
        this.passportNumber = passportNumber;
        this.vehicle = vehicle;
        this.vehicleCode = vehicleCode;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
