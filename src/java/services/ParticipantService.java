/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DBManager;
import domain.Event;
import domain.Participant;
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
public class ParticipantService {
    private DBManager dbmanager;

    public DBManager getDbmanager() {
        return dbmanager;
    }

    public void setDbmanager(DBManager dbmanager) {
        this.dbmanager = dbmanager;
    }
    @GET
    @Produces("application/json")
    public List<Participant> getAllParticipants() {
        List<Participant> participants = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            participants = (List<Participant>) session.getNamedQuery("getAllParticipants").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return participants;
    }
    
   @GET
   @Path("/{participant_id}")
    @Produces("application/json")
    public List<Participant> getAllParticipants(@PathParam("participant_id") long participant_id) {
        List<Participant> participants = null;
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            participants = (List<Participant>) session.getNamedQuery("findParticipantById").setLong("participant_id",participant_id).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return participants;
    }
    
    @POST
    @Consumes("application/json")
    public void createParticipant(Participant objParticipant) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objParticipant);
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
    public void updateParticipant(Participant objParticipant) { // this object was passed from calling method e.g. ajax
        Session session = dbmanager.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            /// this will insert the record in database
            session.save(objParticipant);
            tx.commit();
        } catch (Exception e) {
            System.out.println("xxxx++++"+e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    }
}
