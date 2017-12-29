package com.hobbygo.web.hobbygoweb.dao.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hobbygo.web.hobbygoweb.model.Address;
import com.hobbygo.web.hobbygoweb.model.Link;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventoResource {
    private String eventoId;
    private String name;
    private DateResource date;
    private Address address;
    private List<Link> links;

    private EventoResource(){}

    public EventoResource(String eventoId, String name, List<Link> links){
        setEventoId(eventoId);
        setName(name);
        setLinks(links);
    }

    public String getEventoId() {
        return eventoId;
    }

    private void setEventoId(String eventoId) {
        this.eventoId = eventoId;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public DateResource getDate() {
        return date;
    }

    public LocalDateTime getLocalDateTime(){
        return LocalDateTime.of(getDate().getYear(),getDate().getMonth(),getDate().getDay(),
                getDate().getHour(),getDate().getMinute(),getDate().getSecond());
    }

    public LocalDate getLocalDate(){
        return LocalDate.of(getDate().getYear(),getDate().getMonth(),getDate().getDay());
    }

    public LocalTime getLocalTime(){
        return LocalTime.of(getDate().getHour(),getDate().getMinute(),getDate().getSecond());
    }

    public void setDate(DateResource date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
