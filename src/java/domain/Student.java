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
public class Student extends User{

    private long student_id;
    private String fname;
    private String lname;
    private String phone;
    private String email;
    private String temporaryAddress;
    private String permenantAddress;
    private long batch_id;

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
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

    public String getPhone() {
        return phone.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email.trim();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTemporaryAddress() {
        return temporaryAddress.trim();
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public String getPermenantAddress() {
        return permenantAddress.trim();
    }

    public void setPermenantAddress(String permenantAddress) {
        this.permenantAddress = permenantAddress;
    }

    public long getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(long batch_id) {
        this.batch_id = batch_id;
    }
}
