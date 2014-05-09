/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

public class Customer {
    private long customer_id;
    private String title;
    private String address;

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
    
    public String getTitle() {
        return title!=null ? title.trim() : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address!=null ? address.trim() : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }    
    
}
