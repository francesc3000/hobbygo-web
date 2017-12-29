package com.hobbygo.web.hobbygoweb.model;

import java.time.LocalDateTime;

public class Evento {

    private String id;
    private String name;
    private LocalDateTime date;
    private Address address;

    public Evento(String id, String name){
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
