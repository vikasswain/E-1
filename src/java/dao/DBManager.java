/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ashish
 */
public class DBManager {
    private SessionFactory sessionFactory;

    public DBManager(){
        try{
        sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Exception e){
            System.out.println("XXXXXXXX" + e.getMessage());
        }
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
