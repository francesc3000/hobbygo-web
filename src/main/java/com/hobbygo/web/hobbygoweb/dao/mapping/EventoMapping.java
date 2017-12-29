package com.hobbygo.web.hobbygoweb.dao.mapping;

import com.hobbygo.web.hobbygoweb.dao.resource.EventoResource;
import com.hobbygo.web.hobbygoweb.model.Evento;
import com.hobbygo.web.hobbygoweb.model.list.Evento4List;

public class EventoMapping {

    public static Evento MappingEventoResource2Evento(EventoResource eventoResource){
        return new Evento(eventoResource.getEventoId(),eventoResource.getName());
    }

    public static Evento4List MappingEvento4ListResource2Evento(EventoResource eventoResource){
        return new Evento4List(eventoResource.getEventoId(),eventoResource.getName(),
                eventoResource.getLocalDate(), eventoResource.getLocalTime(),
                eventoResource.getAddress().getCity());
    }
}
