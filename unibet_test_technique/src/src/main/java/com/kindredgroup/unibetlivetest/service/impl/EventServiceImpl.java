package com.kindredgroup.unibetlivetest.service.impl;

import com.kindredgroup.unibetlivetest.entity.Event;
import com.kindredgroup.unibetlivetest.repository.EventRepository;
import com.kindredgroup.unibetlivetest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    //Méthode pour récupérer tous les events
    @Override
    public List<Event> findAll() {
        return new ArrayList<Event>(eventRepository.findAll());
    }

    //Méthode pour récupérer un event selon son id
    @Override
    public Event findById(Long id) {
        if(eventRepository.findById(id).isPresent()) {
            return eventRepository.findById(id).get();
        }
        return null;
    }
}
