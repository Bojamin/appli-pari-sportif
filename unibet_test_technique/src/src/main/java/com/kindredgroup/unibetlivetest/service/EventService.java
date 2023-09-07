package com.kindredgroup.unibetlivetest.service;

import com.kindredgroup.unibetlivetest.entity.Event;

import java.util.List;


public interface EventService {

    //Méthode pour récupérer tous les events
    public List<Event> findAll();

    //Méthode pour récupérer un event via son id
    public Event findById(Long id);
}
