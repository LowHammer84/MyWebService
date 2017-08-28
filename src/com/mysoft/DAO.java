package com.mysoft;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DAO {

    public static List<Event> eventsList;

    public static List<Event> getEventsList() {
        try (Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM schedule ORDER BY d_Time");
            ResultSet resultSet = ps.executeQuery()) {

            eventsList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("_id");
                String title = resultSet.getString("title");
                String information = resultSet.getString("information");
                long unixTime = resultSet.getLong("d_Time");
                Event  event = new Event(id, title, unixTime, information);
                eventsList.add(event);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return eventsList;
    }



    public static void deleteEvent(int id) {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM schedule WHERE _id =?"))
        {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void addEvent(String title, String depart_time, String information, String date) {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO orchestra.schedule (title, depart_time, information, d_Time) VALUES (?, ?, ?, ?)"))
        {

            String fullDate = date + " " + depart_time;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(dateFormat.parse(fullDate).getTime());

            ps.setString(1, title);
            ps.setString(2, depart_time);
            ps.setString(3, information);
            ps.setLong(4, calendar.getTimeInMillis());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/orchestra?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "lwz7wl3g");
    }





}
