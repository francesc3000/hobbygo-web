package com.hobbygo.web.hobbygoweb.ui;

import com.vaadin.addon.geolocation.Coordinates;
import com.vaadin.addon.geolocation.Geolocation;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
@SpringViewDisplay
@Title("Eventos")
public class MainUI extends UI {
    @Autowired
    ViewEventoList viewEventoList;

    @Override
    protected void init(VaadinRequest request) {
        UI ui = getUI();

        VerticalLayout verticalLayout = new VerticalLayout();

        final Geolocation geolocation = new Geolocation(this.getUI());
        final Button currentPositionButton = new Button("Current position", VaadinIcons.MAP_MARKER);
        currentPositionButton.addClickListener(click -> {
            geolocation.getCurrentPosition(position -> {
                Coordinates coordinates = position.getCoordinates();
                Double latitude = coordinates.getLatitude();
                Double longitue = coordinates.getLongitude();
            });
        });

        verticalLayout.addComponent(currentPositionButton);
        verticalLayout.addComponent(viewEventoList);

        setContent(verticalLayout);
    }
}
