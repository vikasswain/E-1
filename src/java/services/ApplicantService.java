/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Neeraj
created Services for APllicant class 

*/

package services;


import dao.DBManager;
import domain.Applicant;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashish
 */
public class ApplicantService {
    
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
     *@return list of applicants
     */
    @GET
    @Produces("application/json")
    public List<Applicant> getAllApplicants() {
        List<Applicant> applicant;
        applicant = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            applicant = (List<Applicant>) session.getNamedQuery("getAllApplicants").list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return applicant;
    }
    
    /**
     * GET by id
     *
     * @param app_id
     * @return list
     */
    @GET
    @Path("/{app_id}")
    @Produces("application/json")
    public List<Applicant> findApplicantById(@PathParam("app_id") String app_id) {
        List<Applicant> applicant = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            applicant = (List<Applicant>) session.getNamedQuery("findApplicantById").setString("app_id", app_id).list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return applicant;
    }
/**
     * GET by eligibilty
     *
     * @param is_eligible
     * @return list
     */
    @GET
    @Path("/eligible/{is_eligible}")
    @Produces("application/json")
    public List<Applicant> findApplicantByEligibilty(@PathParam("is_eligible") String is_eligible) {
        List<Applicant> applicant = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            applicant = (List<Applicant>) session.getNamedQuery("findApplicantByEligibilty").setString("is_eligible", is_eligible).list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return applicant;
    }

    /**
     * PUT
     * 
     * @param objApplicant 
     */
    @PUT
    @Consumes("application/json")
    public void updateApplicant(Applicant objApplicant) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will update the record in database, using app_id in objApplicant
            session.update(objApplicant);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Update Exception \n"+ e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * POST
     * 
     * @param objApplicant 
     */
    
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public void createApplicant(Applicant objApplicant) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objApplicant);
            tx.commit();
            
        } catch (HibernateException e) {
            System.out.println("Create Error"+ e.getMessage());
        } finally {
            session.close();
        }
    }
}
