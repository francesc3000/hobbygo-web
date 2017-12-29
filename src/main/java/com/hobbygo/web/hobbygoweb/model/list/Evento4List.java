package com.hobbygo.web.hobbygoweb.model.list;

import com.vaadin.peter.addon.beangrid.GridColumn;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento4List {
    private String id;
    @GridColumn(defaultOrder = 0, translationKey = "Nombre")
    private String name;
    @GridColumn(defaultOrder = 1, translationKey = "Fecha")
    private LocalDate date;
    @GridColumn(defaultOrder = 2, translationKey = "Hora")
    private LocalTime time;
    @GridColumn(defaultOrder = 3, translationKey = "Lugar")
    private String city;

    public Evento4List(String id, String name, LocalDate date, LocalTime time, String city){
        setId(id);
        setName(name);
        setDate(date);
        setTime(time);
        setCity(city);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
