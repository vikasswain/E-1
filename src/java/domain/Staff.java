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
public class Staff extends User{

    private long staff_id;
    private String fname;
    private String lname;
    private String designation;
    private String email;
    private String phone;

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public String getFname() {
        return fname.trim();
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname.trim();
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDesignation() {
        return designation.trim();
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email.trim();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
