/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DBManager;
import domain.Event;
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
 * @author mahesh
 */
public class EventService {
    private DBManager dbmanager;

    public DBManager getDbmanager() {
        return dbmanager;
    }

    public void setDbmanager(DBManager dbmanager) {
        this.dbmanager = dbmanager;
    }
    
    @GET
    @Produces("application/json")
    public List<Event> getAllEvents() {
        List<Event> events = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            events = (List<Event>) session.getNamedQuery("getAllEvents").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return events;
    }
    
    @GET
   @Path("/{event_id}")
    @Produces("application/json")
    public List<Event> findEventById(@PathParam("event_id") long event_id) {
        List<Event> events = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            events = (List<Event>) session.getNamedQuery("findEventById").setLong("event_id",event_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return events;
    }
    
    @GET
    @Path("/byeventname/{event_name}")
    @Produces("application/json")
    public List<Event> findEventByName(@PathParam("event_name") String event_name) {
        List<Event> events = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            events = (List<Event>) session.getNamedQuery("findEventByName").setString("event_name", event_name).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return events;
    }
    
    @POST
    @Consumes("application/json")
    public void createEvent(Event objEvent) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objEvent);
            tx.commit();
        } catch (Exception e) {
            System.out.println("xxxx++++"+e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    }
    
    @PUT
    @Consumes("application/json")
    public void updateEvent(Event objEvent) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.update(objEvent);
            tx.commit();
        } catch (Exception e) {
            System.out.println("xxxx++++"+e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    }
    
}
