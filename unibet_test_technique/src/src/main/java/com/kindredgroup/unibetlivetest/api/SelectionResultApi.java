package com.kindredgroup.unibetlivetest.api;

import com.kindredgroup.unibetlivetest.entity.Bet;
import com.kindredgroup.unibetlivetest.service.BetService;
import com.kindredgroup.unibetlivetest.service.SelectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Urls.SELECTION)
@CrossOrigin(origins = "*")
public class SelectionResultApi {

    @Autowired
    SelectionResultService selectionResultService;

    /**
     *  Méthode pour directement mettre une selection en WON
     *
     * @param id Id de la sélection
     */
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") Long id) {
        selectionResultService.update(id);
    }

}
