/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author neeraj re-designed
 * Student Class for the Storing Information about Active / Admitted Students
 * 
 */
public class Student{

    private String reg_no;
    private String roll_no;
    private String app_id;

    private String course_id;
    private String batch_id;
    private boolean is_defaulter; // whether a student has paid fees or not 
   
    //logging purpose variables
    private String created_by;
    private Timestamp creation_time;                        
    private String updated_by;        
    private Timestamp updation_time;                
    private boolean is_deleted;
    private String deleted_by;
    private Timestamp deletion_time;

    
    public Student(){}
    
    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public boolean getIs_defaulter() {
        return is_defaulter;
    }

    public void setIs_defaulter(boolean is_defaulter) {
        this.is_defaulter = is_defaulter;
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


    
       
 }//class

