/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
After Redesigning 
 */

package domain;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Neeraj
 */
public class Applicant {

private String app_id;
private String first_name;
private String middle_name;
private String last_name;
private Date date_of_birth;

    
private char gender;
private String email;
private String religion;
private String caste_id;
private String nationality;
private double parents_income;
private float percentage;

private String last_exam_passed;
private Date year_of_passing;
private String course_to_be_admitted;

private boolean is_eligible;
private String address;
private String locality;
private String city;
private String zipcode;
private String state;  


//logging purpose variables
private String created_by;
private Timestamp creation_time;                        
private String updated_by;        
private Timestamp updation_time;                
private boolean is_deleted;
private String deleted_by;
private Timestamp deletion_time;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCaste_id() {
        return caste_id;
    }

    public void setCaste_id(String caste_id) {
        this.caste_id = caste_id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getParents_income() {
        return parents_income;
    }

    public void setParents_income(double parents_income) {
        this.parents_income = parents_income;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getLast_exam_passed() {
        return last_exam_passed;
    }

    public void setLast_exam_passed(String last_exam_passed) {
        this.last_exam_passed = last_exam_passed;
    }

    public Date getYear_of_passing() {
        return year_of_passing;
    }

    public void setYear_of_passing(Date year_of_passing) {
        this.year_of_passing = year_of_passing;
    }

    public String getCourse_to_be_admitted() {
        return course_to_be_admitted;
    }

    public void setCourse_to_be_admitted(String course_to_be_admitted) {
        this.course_to_be_admitted = course_to_be_admitted;
    }

    public boolean isIs_eligible() {
        return is_eligible;
    }

    public void setIs_eligible(boolean is_eligible) {
        this.is_eligible = is_eligible;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Timestamp creation_time) {
        this.creation_time = creation_time;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Timestamp getUpdation_time() {
        return updation_time;
    }

    public void setUpdation_time(Timestamp updation_time) {
        this.updation_time = updation_time;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public Timestamp getDeletion_time() {
        return deletion_time;
    }

    public void setDeletion_time(Timestamp deletion_time) {
        this.deletion_time = deletion_time;
    }
public Applicant(){}
    
    
}

