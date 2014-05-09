/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

public class Course {

    private long course_id;
    private String abbr;
    private String title;

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getAbbr() {
        return abbr!=null ? abbr.trim() : abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getTitle() {
        return title!=null ? title.trim() : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
