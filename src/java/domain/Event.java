/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author mahesh
 */
public class Event {
    long event_id;
    String event_name;
    String event_description;
    int event_year;

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name!=null ? event_name.trim() : event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_description() {
        return event_description!=null ? event_description.trim() : event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public int getEvent_year() {
        return event_year;
    }

    public void setEvent_year(int event_year) {
        this.event_year = event_year;
    }
    
    
    
    
}
