package com.kindredgroup.unibetlivetest.api;

import com.kindredgroup.unibetlivetest.entity.Event;
import com.kindredgroup.unibetlivetest.service.EventService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(Urls.BASE_PATH)
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventApi {

    @Autowired
    private EventService eventService;

    /** TODO
     *  @GetMapping(Urls.EVENTS)
     */
    /**
     *
     * @param isLive
     * @return
     */
    @GetMapping(Urls.EVENTS)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Succès"),
            @ApiResponse(code = 204, message = "Pas de live"),
            @ApiResponse(code = 400, message = "Request mal formée"),
            @ApiResponse(code = 500, message = "Erreur Serveur")
    })
    public List<Event> recupererEvents(Boolean isLive){
        return eventService.findAll();
    }

    /** TODO
     *  @GetMapping(Urls.SELECTIONS)
     */
    @GetMapping(Urls.SELECTIONS)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Succès"),
            @ApiResponse(code = 204, message = "Pas de live"),
            @ApiResponse(code = 400, message = "Request mal formée"),
            @ApiResponse(code = 404, message = "Evènement introuvable"),
            @ApiResponse(code = 500, message = "Erreur Serveur")
    })
    public Event recupererEventParId(@PathVariable("id") Long id){
        return eventService.findById(id);
    }


}
