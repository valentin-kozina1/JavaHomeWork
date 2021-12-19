package com.pb.kozina.hw11;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public  class PhoneNumber {
    private String FIO;
    private LocalDate dateOfBirth;
    private  String phone;
    private String adress;
    private LocalDate dateOfRegistration;

    public PhoneNumber(){};

    public PhoneNumber(
            String FIO,
            LocalDate dateOfBirth,
            String phone,
            String adress,
            LocalDate dateOfRegistration) {
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.adress = adress;
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getFIO() {return FIO;}
    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public String getPhone() {return phone;}
    public String getAdress() {return adress;}
    public LocalDate getDateOfRegistration() {return dateOfRegistration;}

    public void setFIO(String FIO) {this.FIO = FIO;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setAdress(String adress) {this.adress = adress;}
    public void setDateOfRegistration(LocalDate dateOfRegistration) {this.dateOfRegistration = dateOfRegistration;}

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "FIO='" + FIO + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phone=" + phone +'\'' +
                ", adress='" + adress + '\'' +
                ", dateOfRegistration='" + dateOfRegistration +
                '}';
    }
}
