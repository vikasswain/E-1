/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

public class User {

    private long user_id;
    private String ufname;
    private String ulname;
    private String uname;
    private String pwd;
    private long customer_id;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUname() {
        return uname!=null? uname.trim() : uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd!=null? pwd.trim() : pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUfname() {
        return ufname!=null? ufname.trim() : ufname;
    }

    public void setUfname(String ufname) {
        this.ufname = ufname;
    }

    public String getUlname() {
        return ulname!=null? ulname.trim() : ulname;
    }

    public void setUlname(String ulname) {
        this.ulname = ulname;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
}
