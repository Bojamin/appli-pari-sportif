package com.kindredgroup.unibetlivetest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kindredgroup.unibetlivetest.entity.Event;
import com.kindredgroup.unibetlivetest.entity.Market;
import com.kindredgroup.unibetlivetest.entity.Selection;
import jdk.vm.ci.code.site.Mark;

import java.util.List;
import java.util.Set;


public interface EventService {

    //Méthode pour récupérer tous les events
    public List<Event> findAll(Boolean isLive);

    //Méthode pour récupérer les selections via les markets via l'id event
    List<Selection> recupererSelectionsParEvent(Long id);
}
