/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DBManager;
import domain.Batch;
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
public class BatchService {
    
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
    public List<Batch> getAllBatches() {
        List<Batch> batchs = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            batchs = (List<Batch>) session.getNamedQuery("getAllBatches").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return batchs;
    }
    
    /**
     * GET by id
     *
     * @param batch_id
     * @return list
     */
    @GET
    @Path("/{batch_id}")
    @Produces("application/json")
    public List<Batch> findBatchById(@PathParam("batch_id") long batch_id) {
        List<Batch> batchs = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            batchs = (List<Batch>) session.getNamedQuery("findBatchById").setLong("batch_id", batch_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return batchs;
    }
    
    /**
     * GET by course_id
     *
     * @param course_id
     * @return list
     */
    @GET
    @Path("/bycourse/{course_id}")
    @Produces("application/json")
    public List<Batch> getBatchesByCourseId(@PathParam("course_id") long course_id) {
        List<Batch> batchs = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            batchs = (List<Batch>) session.getNamedQuery("getBatchesByCourseId").setLong("course_id", course_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return batchs;
    }
    
    /**
     * GET by year
     *
     * @param year
     * @return list
     */
    @GET
    @Path("/byyear/{passout_year}")
    @Produces("application/json")
    public List<Batch> getBatchesByYear(@PathParam("passout_year") int passout_year) {
        List<Batch> batchs = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            batchs = (List<Batch>) session.getNamedQuery("getBatchesByYear").setInteger("passout_year", passout_year).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return batchs;
    }

    /**
     * PUT
     * 
     * @param objBatch 
     */
    @PUT
    @Consumes("application/json")
    public void updateBatch(Batch objBatch) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will update the record in database, using batch_id in objBatch
            session.update(objBatch);
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
     * @param objBatch 
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public void createBatch(Batch objBatch) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objBatch);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}
