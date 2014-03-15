/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DBManager;
import domain.Staff;
import domain.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashish
 */
public class StaffService {

    // initialized by spring. provides singleton SessionFactory object per application
    private DBManager dbmanager;

    public DBManager getDbmanager() {
        return dbmanager;
    }

    public void setDbmanager(DBManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    // services start here
    /**
     * GET all
     *
     * @param
     * @return list
     */
    @GET
    @Produces("application/json")
    public List<Staff> getAllStaffs() {
        List<Staff> staffs = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            staffs = (List<Staff>) session.getNamedQuery("getAllStaffs").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return staffs;
    }

    /**
     * GET by id
     *
     * @param staff_id
     * @return list
     */
    @GET
    @Path("/{staff_id}")
    @Produces("application/json")
    public List<Staff> findStaffById(@PathParam("staff_id") long staff_id) {
        List<Staff> staffs = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            staffs = (List<Staff>) session.getNamedQuery("findStaffById").setLong("staff_id", staff_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return staffs;
    }

    /**
     * GET by user_id
     *
     * @param user_id
     * @return list
     */
    @GET
    @Path("/byuser/{user_id}")
    @Produces("application/json")
    public List<Staff> findStaffByUserId(@PathParam("user_id") long user_id) {
        List<Staff> staffs = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            staffs = (List<Staff>) session.getNamedQuery("findStaffByUserId").setLong("user_id", user_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return staffs;
    }

    /**
     * PUT
     *
     * @param objStaff
     */
    @PUT
    @Consumes("application/json")
    public void updateStaff(Staff objStaff) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            User objUser = new User();
            objUser.setUser_id(objStaff.getUser_id());
            objUser.setUname(objStaff.getUname());
            objUser.setPwd(objStaff.getPwd());
            /// this will update the record in database, using staff_id in objStaff
            session.update(objStaff);
            /// this will update the record in database, using user_id in objUser
            session.update(objUser);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * POST
     *
     * @param objStaff
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public void createStaff(Staff objStaff) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            User objUser = new User();
            objUser.setUname(objStaff.getUname());
            objUser.setPwd(objStaff.getPwd());
            /// this will insert 2 records in database
            objStaff.setUser_id(Long.parseLong(session.save(objUser) + ""));
            session.save(objStaff);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}
