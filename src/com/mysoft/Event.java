package com.mysoft;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event {

    public Event() {
    }
    int id;
    String title;
    String depart_time;
    String information;
    String date;
    long unixTime;


    public Event(int id, String title, long unixTime, String information) {
        this.id = id;
        this.title = title;
        this.information = information;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(unixTime);
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        this.date = df.format(calendar.getTime());
        df.applyPattern("HH:mm");
        this.depart_time = df.format(calendar.getTime());
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
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

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }
}
