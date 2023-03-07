
package com.model;

import javax.persistence.*;
@Entity
public class RegisterStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_Id;
    private String firstname;
    private String lastname;
    private String gender;
    private String age;
    private String country;
    private String photo;
    private String file;

    public RegisterStudent() {
    }

    public RegisterStudent(int student_Id, String firstname, String lastname, String gender, String age, String country, String photo, String file) {
        this.student_Id = student_Id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.country = country;
        this.photo = photo;
        this.file = file;
    }

    public int getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}