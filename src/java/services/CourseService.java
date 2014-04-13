/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DBManager;
import domain.Course;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CourseService {
    
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
    public List<Course> getAllCourses() {
        List<Course> courses = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            courses = (List<Course>) session.getNamedQuery("getAllCourses").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return courses;
    }
    
    /**
     * GET by id
     *
     * @param course_id
     * @return list
     */
    @GET
    @Path("/{course_id}")
    @Produces("application/json")
    public List<Course> findCourseById(@PathParam("course_id") long course_id) {
        List<Course> courses = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            courses = (List<Course>) session.getNamedQuery("findCourseById").setLong("course_id", course_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return courses;
    }

    /**
     * PUT
     * 
     * @param objCourse 
     */
    @PUT
    @Consumes("application/json")
    public void updateCourse(Course objCourse) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will update the record in database, using course_id in objCourse
            session.update(objCourse);
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
     * @param objCourse 
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public void createCourse(Course objCourse) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objCourse);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
    
    @DELETE
    @Consumes("application/json")
    public void deleteCourse(Course objCourse) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will delete the record in database, using course_id in objCourse
            session.delete(objCourse);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }    
    
    
}
