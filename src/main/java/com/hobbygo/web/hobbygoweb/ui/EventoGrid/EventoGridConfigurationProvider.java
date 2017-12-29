package com.hobbygo.web.hobbygoweb.ui.EventoGrid;

import com.vaadin.peter.addon.beangrid.GridConfigurationProvider;
import com.vaadin.shared.util.SharedUtil;
import com.vaadin.spring.annotation.SpringComponent;

import java.util.Optional;

@SpringComponent
public class EventoGridConfigurationProvider implements GridConfigurationProvider{
    @Override
    public String resolveTranslationKey(String translationKey) {
        if ("true".equals(translationKey)) {
            return "yep";
        } else if ("false".equals(translationKey)) {
            return "nope";
        } else if ("this.is.static.text".equals(translationKey)) {
            return "Static footer text";
        }

        return SharedUtil.propertyIdToHumanFriendly(translationKey);
    }

    @Override
    public Optional<String> getDateFormatPattern() {
        return Optional.of("dd-MM-yyyy");
    }

}
