package com.hobbygo.web.hobbygoweb.service;

import com.hobbygo.web.hobbygoweb.dao.RootDao;
import com.hobbygo.web.hobbygoweb.model.list.Evento4List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RootService {

    @Autowired
    private RootDao rootDao;

    public void eventoRegister(String email) {
        rootDao.eventoRegister(email);
    }

    public List<Evento4List> getEventos() {
        //TODO: Recoger la ubicación
        return rootDao.getEventos(40.1f, 24.1f,50000);
    }

    public int getCountEventos() {
        //TODO: Recoger la ubicación
        return rootDao.getCountEventos(40.1f, 24.1f,5000);
    }

    public void googleConnect() {
        rootDao.googleConnect();
    }
}
