/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DBManager;
import domain.Student;
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
public class StudentService {

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
    public List<Student> getAllStudents() {
        List<Student> students = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            students = (List<Student>) session.getNamedQuery("getAllStudents").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return students;
    }

    /**
     * GET by id
     *
     * @param student_id
     * @return list
     */
    @GET
    @Path("/{student_id}")
    @Produces("application/json")
    public List<Student> findStudentById(@PathParam("student_id") long student_id) {
        List<Student> students = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            students = (List<Student>) session.getNamedQuery("findStudentById").setLong("student_id", student_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return students;
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
    public List<Student> findStudentByUserId(@PathParam("user_id") long user_id) {
        List<Student> students = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            students = (List<Student>) session.getNamedQuery("findStudentByUserId").setLong("user_id", user_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return students;
    }

    /**
     * GET by id
     *
     * @param student_id
     * @return list
     */
    @GET
    @Path("/bybatch/{batch_id}")
    @Produces("application/json")
    public List<Student> getStudentsByBatchId(@PathParam("batch_id") long batch_id) {
        List<Student> students = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            students = (List<Student>) session.getNamedQuery("getStudentsByBatchId").setLong("batch_id", batch_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return students;
    }

    /**
     * PUT
     *
     * @param objStudent
     */
    @PUT
    @Consumes("application/json")
    public void updateStudent(Student objStudent) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            User objUser = new User();
            objUser.setUser_id(objStudent.getUser_id());
            objUser.setUname(objStudent.getUname());
            objUser.setPwd(objStudent.getPwd());
            /// this will update the record in database, using student_id in objStudent
            session.update(objStudent);
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
     * @param objStudent
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public void createStudent(Student objStudent) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            User objUser = new User();
            objUser.setUname(objStudent.getUname());
            objUser.setPwd(objStudent.getPwd());
            /// this will insert the record in database
            objStudent.setUser_id(Long.parseLong(session.save(objUser) + ""));
            session.save(objStudent);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}
