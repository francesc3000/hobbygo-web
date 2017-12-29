package com.hobbygo.web.hobbygoweb.ui.EventoGrid;

import com.hobbygo.web.hobbygoweb.model.list.Evento4List;
import com.hobbygo.web.hobbygoweb.service.RootService;
import com.vaadin.data.provider.AbstractBackEndDataProvider;
import com.vaadin.data.provider.Query;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@SpringComponent
public class EventoDataProvider extends AbstractBackEndDataProvider<Evento4List, String> {
    @Autowired
    private RootService rootService;

    @Override
    protected Stream<Evento4List> fetchFromBackEnd(Query<Evento4List, String> query) {
        return rootService.getEventos().stream();
    }

    @Override
    protected int sizeInBackEnd(Query<Evento4List, String> query) {
        return rootService.getCountEventos();
    }

    @Override
    public Object getId(Evento4List evento4List) {
        return evento4List.getId();
    }
}
