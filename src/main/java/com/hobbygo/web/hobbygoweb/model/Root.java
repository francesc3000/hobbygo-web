package com.hobbygo.web.hobbygoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private List<Link> links;

    private Root(){}

    public Root(Link link){
        setLinks(new ArrayList<>());
        getLinks().add(link);
    }

    public List<Link> getLinks() {
        return links;
    }

    private void setLinks(List<Link> links) {
        this.links = links;
    }
}
