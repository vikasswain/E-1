/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author Neeraj
 */
public class Applicant {

private String app_id;
private String first_name;
private String middle_name;
private String last_name;
private String last_exam_passed;
private float percentage;
private int year_of_passing;
private String course_to_be_admitted;
private String course_id;
private String is_eligible;
    public String getIs_eligible() {
        return is_eligible;
    }

    public void setIs_eligible(String is_eligible) {
        this.is_eligible = is_eligible;
    }


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

    public String getLast_exam_passed() {
        return last_exam_passed;
    }

    public void setLast_exam_passed(String last_exam_passed) {
        this.last_exam_passed = last_exam_passed;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getYear_of_passing() {
        return year_of_passing;
    }

    public void setYear_of_passing(int year_of_passing) {
        this.year_of_passing = year_of_passing;
    }

    public String getCourse_to_be_admitted() {
        return course_to_be_admitted;
    }

    public void setCourse_to_be_admitted(String course_to_be_admitted) {
        this.course_to_be_admitted = course_to_be_admitted;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

   

}
