package com.mysoft;


import java.sql.Date;

public class Event {

    public Event() {
    }
    int id;
    String title;
    String begin_time;
    String depart_time;
    String information;
    Date   date;

    public String getTitle() {
        return title;
    }

    public Event(int id, String title, String begin_time, String depart_time, String information, Date date) {
        this.id = id;
        this.title = title;
        this.begin_time = begin_time;
        this.depart_time = depart_time;
        this.information = information;
        if (date != null) {
            this.date = date;
        } else {
            this.date = new Date(2017, 01, 01);
        }


    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(String depart_time) {
        this.depart_time = depart_time;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", begin_time='" + begin_time + '\'' +
                '}';
    }
}
