package com.kindredgroup.unibetlivetest.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kindredgroup.unibetlivetest.entity.Event;
import com.kindredgroup.unibetlivetest.entity.Market;
import com.kindredgroup.unibetlivetest.entity.Selection;
import com.kindredgroup.unibetlivetest.service.EventService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Log4j2
@RequestMapping(Urls.BASE_PATH)
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventApi {

    @Autowired
    private EventService eventService;

    /** TODO
     *  Méthode pour récupérer tous les events ou seulement ceux en cours
     *
     * @param isLive Permet de savoir si un event est en cours ou non.
     * @return Retourne tous une liste d'évènement.
     */
    @GetMapping(Urls.EVENTS)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Succès"),
            @ApiResponse(code = 204, message = "Pas de live"),
            @ApiResponse(code = 400, message = "Request mal formée"),
            @ApiResponse(code = 500, message = "Erreur Serveur")
    })
    public List<Event> recupererEvents(@RequestParam Boolean isLive){
        return eventService.findAll(isLive);
    }

    /**
     *  Méthode pour récupérer les selections via les markets via l'id event
     *
     * @param id Id de l'event
     * @return Le(s) event(s) selon l'id event
     */
    @GetMapping(Urls.SELECTIONS)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Succès"),
            @ApiResponse(code = 204, message = "Pas de live"),
            @ApiResponse(code = 400, message = "Request mal formée"),
            @ApiResponse(code = 404, message = "Evènement introuvable"),
            @ApiResponse(code = 500, message = "Erreur Serveur")
    })
    public List<Selection> recupererEventParId(@PathVariable("id") Long id) {
        return eventService.recupererSelectionsParEvent(id);

    }

}
