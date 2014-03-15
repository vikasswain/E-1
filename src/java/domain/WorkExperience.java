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
public class WorkExperience {

    private long entry_id;
    private String organization;
    private String designation;
    private String roleDescription;
    private Short months;
    private Short years;
    private long student_id;

    public long getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(long entry_id) {
        this.entry_id = entry_id;
    }

    public String getOrganization() {
        return organization.trim();
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDesignation() {
        return designation.trim();
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRoleDescription() {
        return roleDescription.trim();
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Short getMonths() {
        return months;
    }

    public void setMonths(Short months) {
        this.months = months;
    }

    public Short getYears() {
        return years;
    }

    public void setYears(Short years) {
        this.years = years;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }
}
