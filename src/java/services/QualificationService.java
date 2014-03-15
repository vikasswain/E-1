/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DBManager;
import domain.Qualification;
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
public class QualificationService {
    
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
     * @param student_id
     * @return list
     */
    @GET
    @Path("/bystudent/{student_id}")
    @Produces("application/json")
    public List<Qualification> getQualifications(@PathParam("student_id") long student_id) {
        List<Qualification> qualifications = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            qualifications = (List<Qualification>) session.getNamedQuery("getQualifications").setLong("student_id", student_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return qualifications;
    }
    
    /**
     * GET by id
     *
     * @param entry_id
     * @return list
     */
    @GET
    @Path("/{entry_id}")
    @Produces("application/json")
    public List<Qualification> findQualificationById(@PathParam("entry_id") long entry_id) {
        List<Qualification> qualifications = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            qualifications = (List<Qualification>) session.getNamedQuery("findQualificationById").setLong("entry_id", entry_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return qualifications;
    }

    /**
     * PUT
     * 
     * @param objQualification 
     */
    @PUT
    @Consumes("application/json")
    public void updateQualification(Qualification objQualification) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will update the record in database, using entry_id in objQualification
            session.update(objQualification);
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
     * @param objQualification 
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public void createQualification(Qualification objQualification) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objQualification);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}
