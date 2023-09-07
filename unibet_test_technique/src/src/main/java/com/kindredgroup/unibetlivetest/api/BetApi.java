package com.kindredgroup.unibetlivetest.api;

import com.kindredgroup.unibetlivetest.entity.Bet;
import com.kindredgroup.unibetlivetest.service.BetService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Urls.BETS)
@CrossOrigin(origins = "*")
public class BetApi {

    @Autowired
    BetService betService;

    /** TODO
     *  @PostMapping(Urls.ADD_BET)
     */
    //Chemin pour post un bet
    @PostMapping(Urls.ADD_BET)
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Succès"),
            @ApiResponse(code = 400, message = "Request mal formée"),
            @ApiResponse(code = 409, message = " Conflit, pari déjà en cours"),
            @ApiResponse(code = 500, message = "Erreur Serveur"),
            @ApiResponse(code = 600, message = "Balance insuffisante"),
            @ApiResponse(code = 601, message = "Changement de cote"),
            @ApiResponse(code = 602, message = "Selection fermée")
    })
    public Long create(@RequestBody Bet bet, @PathVariable("id") Long id) {
        return betService.create(bet, id);
    }

}
