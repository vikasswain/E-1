/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author ashish
 */
public class Qualification {

    private long entry_id;
    private String qualification;
    private double percentage;
    private String institute;
    private String university;
    private String description;
    private long student_id;

    public long getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(long entry_id) {
        this.entry_id = entry_id;
    }

    public String getQualification() {
        return qualification.trim();
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getInstitute() {
        return institute.trim();
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getUniversity() {
        return university.trim();
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDescription() {
        return description.trim();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }
}
