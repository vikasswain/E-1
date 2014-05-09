/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DBManager;
import domain.Customer;
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


public class CustomerService {
    
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
    public List<Customer> getAllCustomers() {
        List<Customer> customers = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            customers = (List<Customer>) session.getNamedQuery("getAllCustomers").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return customers;
    }
    
    /**
     * GET by id
     *
     * @param customer_id
     * @return list
     */
    @GET
    @Path("/{customer_id}")
    @Produces("application/json")
    public List<Customer> findCustomerById(@PathParam("customer_id") long customer_id) {
        List<Customer> customers = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            customers = (List<Customer>) session.getNamedQuery("findCustomerById").setLong("customer_id", customer_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return customers;
    }

    /**
     * PUT
     * 
     * @param objCustomer 
     */
    @PUT
    @Consumes("application/json")
    public void updateCustomer(Customer objCustomer) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will update the record in database, using customer_id in objCustomer
            session.update(objCustomer);
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
     * @param objCustomer 
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public void createCustomer(Customer objCustomer) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objCustomer);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
    
    @DELETE
    @Consumes("application/json")
    public void deleteCustomer(Customer objCustomer) {  // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will delete the record in database, using customer_id in objCustomer
            session.delete(objCustomer);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }    
    
    
}

