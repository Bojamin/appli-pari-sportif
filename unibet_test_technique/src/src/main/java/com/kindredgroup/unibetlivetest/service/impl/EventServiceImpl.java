package com.kindredgroup.unibetlivetest.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kindredgroup.unibetlivetest.entity.Event;
import com.kindredgroup.unibetlivetest.entity.Market;
import com.kindredgroup.unibetlivetest.entity.Selection;
import com.kindredgroup.unibetlivetest.repository.EventRepository;
import com.kindredgroup.unibetlivetest.repository.MarketRepository;
import com.kindredgroup.unibetlivetest.repository.SelectionRepository;
import com.kindredgroup.unibetlivetest.service.EventService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    MarketRepository marketRepository;

    @Autowired
    SelectionRepository selectionRepository;

    //Méthode pour récupérer tous les events
    @Override
    public List<Event> findAll(Boolean isLive) {
        List<Event> events = eventRepository.findAll();

        //Si isLive est true on regarde si le(s) event(s) n'est pas fermé (un event dure 5 cimutes dans l'énnoncé)
        if(isLive) {

            LocalDateTime now = LocalDateTime.now();

            List<Event> eventsWithin5Minutes = new ArrayList<>();

            for (Event event : events) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                LocalDateTime eventStartDate = LocalDateTime.parse(event.getStartDate().toString(), formatter);

                LocalDateTime fiveMinutesFromNow = eventStartDate.plusMinutes(5);

                if (now.isBefore(fiveMinutesFromNow) || now.isEqual(fiveMinutesFromNow)) {
                    eventsWithin5Minutes.add(event);
                }
            }
        return eventsWithin5Minutes;
    }
        return events;
    }

    //Méthode pour récupérer les selections via les markets via l'id event
    @Override
    public List<Selection> recupererSelectionsParEvent(Long id) {

        List<Market> markets = marketRepository.findByEventId(id);
        List<Selection> bonneSelections = new ArrayList<>();

        for (Market market : markets) {
            Long marketId = market.getId();
            bonneSelections.addAll(selectionRepository.findByMarketId(marketId));
        }
        return bonneSelections;
    }
}
