package com.hobbygo.web.hobbygoweb.ui;

import com.hobbygo.web.hobbygoweb.model.list.Evento4List;
import com.hobbygo.web.hobbygoweb.service.RootService;
import com.hobbygo.web.hobbygoweb.ui.EventoGrid.EventoDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = ViewEventoList.VIEW_NAME)
//@Title("Eventos")
public class ViewEventoList extends VerticalLayout implements View {
    public static final String VIEW_NAME = "eventos";

    @Autowired
    private Grid<Evento4List> grid;

    @Autowired
    private RootService rootService;

    @Autowired
    EventoDataProvider eventoDataProvider;

    //private GeoLocation geoLocation;

    @PostConstruct
    void init() {

/*
 * This Data Provider doesn't load all items into the memory right away.
 * Grid will request only the data that should be shown in its current
 * view "window". The Data Provider will use callbacks to load only a
 * portion of the data.
 */

        grid.setDataProvider(eventoDataProvider);
        grid.addComponentColumn(country -> {
            Button ratingStars = new Button("Registrarse");
            ratingStars.addClickListener(
                    event -> onRegisterClickListener(event));
            return ratingStars;
        }).setCaption("Registro");

        grid.setWidthUndefined();
        grid.setWidth("745");


        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidthUndefined();
        verticalLayout.addComponentsAndExpand(grid);

        addComponent(verticalLayout);

/*
        geoLocation = new GeoLocation();
        geoLocation.addListener(event -> geoLocationReceiver((GeoLocation.GeoLocationReceivedEvent) event));

        //addComponent(geoLocation);

        geoLocation.requestGeoLocation();
        */
    }
/*
    private void geoLocationReceiver(GeoLocation.GeoLocationReceivedEvent event) {
        double latitude = event.getLatitude();
    }
*/
    private void onRegisterClickListener(Button.ClickEvent clickEvent) {
        final Window window = new Window("Window");
        window.setWidth(300.0f, Unit.PIXELS);
        window.center();
        window.setCaption("Correo Electronico");
        window.setResizable(false);
        window.setDraggable(false);
        final FormLayout content = new FormLayout();
        TextField email = new TextField();
        email.setDescription("Correo electronico");
        email.setPlaceholder("Correo electronico");
        email.focus();
        //TODO: Implementar validación
        Button send = new Button("Enviar");
        send.addClickListener(listener -> sendOnClickListener(listener));
        content.addComponent(email);
        content.addComponent(send);
        content.setMargin(true);
        window.setContent(content);
        getUI().addWindow(window);
    }

    private void sendOnClickListener(Button.ClickEvent listener) {
        rootService.eventoRegister(listener.getButton().getData().toString());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }

    public Grid<Evento4List> getGrid() {
        return grid;
    }

    private void setGrid(Grid<Evento4List> grid) {
        this.grid = grid;
    }
}
