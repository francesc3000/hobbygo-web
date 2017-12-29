package com.hobbygo.web.hobbygoweb.model;

public class Link {
    private String rel;
    private String href;

    private Link(){}

    public Link(String rel, String href){
        setRel(rel);
        setHref(href);
    }

    public String getRel() {
        return rel;
    }

    private void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    private void setHref(String href) {
        this.href = href;
    }
}
