package com.hobbygo.web.hobbygoweb.dao;

import com.hobbygo.web.hobbygoweb.dao.resource.EventoResource;
import com.hobbygo.web.hobbygoweb.dao.resource.ResourceCollection;
import com.hobbygo.web.hobbygoweb.model.Link;
import com.hobbygo.web.hobbygoweb.model.Root;
import com.hobbygo.web.hobbygoweb.model.list.Evento4List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.hobbygo.web.hobbygoweb.dao.mapping.EventoMapping.MappingEvento4ListResource2Evento;

@Repository
public class RootDao {
    private final String ROOTLINK = "https://hobbygo-api.herokuapp.com/api/v1";

    @Autowired
    private RestTemplate restTemplate;

    private Root root;

    public Root getRoot(){
        if(root==null)
            root = restTemplate.getForObject(ROOTLINK, Root.class);

        return root;
    }

    public void eventoRegister(String email) {
        //Recuperamos la dirección donde registrarse a un evento


        //restTemplate.postForObject(eventoLink,);
    }

    public List<Evento4List> getEventos(Float longitude, Float latitude, Integer distance) {

         String eventoLink = getEventoLink();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("lon",longitude.toString());
        httpHeaders.add("lat",latitude.toString());
        httpHeaders.add("dis",distance.toString());

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
/*
        ResponseEntity<Evento[]> responseEntity =
                restTemplate.exchange(eventoLink, HttpMethod.GET,entity,Evento[].class);

        List<Evento> eventoList = new ArrayList<>();
        for(Evento evento:responseEntity.getBody())
            eventoList.add(evento);
*/
        ResponseEntity<ResourceCollection<EventoResource>> responseEntity =
                restTemplate.exchange(eventoLink, HttpMethod.GET,
                        entity,new ParameterizedTypeReference<ResourceCollection<EventoResource>>() {});

        List<Evento4List> eventoList = new ArrayList<>();
        for(EventoResource eventoResource:responseEntity.getBody().getData())
            eventoList.add(MappingEvento4ListResource2Evento(eventoResource));

        return eventoList;
    }

    public Integer getCountEventos(Float longitude, Float latitude, Integer distance) {
        String eventoLink = getEventoCountLink();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("lon",longitude.toString());
        httpHeaders.add("lat",latitude.toString());
        httpHeaders.add("dis",distance.toString());

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);

        ResponseEntity<Integer> responseEntity =
                restTemplate.exchange(eventoLink, HttpMethod.GET,entity,Integer.class);

        return responseEntity.getBody();
    }

    private String getEventoLink(){
        for(Link link: getRoot().getLinks())
            if(link.getRel().equals("eventos"))
                return link.getHref();

        return null;
    }

    private String getEventoCountLink(){
        for(Link link: getRoot().getLinks())
            if(link.getRel().equals("eventosCount"))
                return link.getHref();

        return null;
    }

    public void googleConnect(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("scope", "profile");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        restTemplate.postForObject("https://hobbygo-api.herokuapp.com/connect/google",request, String.class);
    }
}
