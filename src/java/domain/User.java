/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author ashish
 */
public class User {

    private long user_id;
    private String uname;
    private String pwd;

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
}
