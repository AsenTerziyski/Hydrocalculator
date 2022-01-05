package com.example.hydrocalc.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
public class UserBrowser extends BaseEntity {
    private String username;
    private String clientsAddress;

    public UserBrowser() {
    }

    public String getUsername() {
        return username;
    }

    public UserBrowser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getClientsAddress() {
        return clientsAddress;
    }

    public UserBrowser setClientsAddress(String clientsAddress) {
        this.clientsAddress = clientsAddress;
        return this;
    }

    @Override
    public String toString() {
        LocalDateTime created = getCreated();
        int dayOfMonth = created.getDayOfMonth();
        int year = created.getYear();
        int month = created.getMonth().getValue();
        String m = "";
        switch (month) {
            case 1:
                m = "January";
                break;
            case 2:
                m = "February";
                break;
            case 3:
                m = "March";
                break;
            case 4:
                m = "April";
                break;
            case 5:
                m = "May";
                break;
            case 6:
                m = "June";
                break;
            case 7:
                m = "July";
                break;
            case 8:
                m = "August";
                break;
            case 9:
                m = "September";
                break;
            case 10:
                m = "October";
                break;
            case 11:
                m = "November";
                break;
            case 12:
                m = "December";
                break;
        }
        return this.username +
                " browsed on " +
                dayOfMonth  + " of " + m + ", " +
                year + ". Clients address: " +
                this.clientsAddress + ";";
    }
}
