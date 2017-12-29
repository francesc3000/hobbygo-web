package com.hobbygo.web.hobbygoweb.dao.resource;

import java.util.Collection;

public class ResourceCollection<T> {

    private Collection<T> data;

    private ResourceCollection(){}

    public ResourceCollection(Collection<T> data) {
        this.data = data;
    }

    public Collection<T> getData() {
        return data;
    }
    
}
