package com.kindredgroup.unibetlivetest.batchs;


import com.kindredgroup.unibetlivetest.entity.Bet;
import com.kindredgroup.unibetlivetest.entity.Customer;
import com.kindredgroup.unibetlivetest.entity.Selection;
import com.kindredgroup.unibetlivetest.repository.BetRepository;
import com.kindredgroup.unibetlivetest.repository.CustomerRepository;
import com.kindredgroup.unibetlivetest.repository.SelectionRepository;
import com.kindredgroup.unibetlivetest.types.SelectionResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@Log4j2
@RequiredArgsConstructor
public class MarketBatch {


    /**
     * TODO
     *  void payerLesParisBatch()
     */
    @Autowired
    private SelectionRepository selectionRepository;

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void payerLesParisBatch() {
        //Je check seulement les selections ayant la selectionresult sur WON
        List<Selection> selectionsWon = selectionRepository.findByResult(SelectionResult.WON);

        log.info("Nombre de selections traitees : {}", selectionsWon.size());

        //Pour ses selections je récupére les bets liés aux sélections gagnantes
        for (Selection selection : selectionsWon) {
            Long selectionId = selection.getId();
            List<Bet> bets = betRepository.findBySelectionId(selectionId);

            //Pour ses bets gagnant je récupère l'utilisateur lié et je lui donne un nouveau montant de gain (la j'ai juste passé la valeur de 50 euros a 75 euros).
            for (Bet bet : bets) {
                Customer customer = bet.getCustomer();
                Long customerId = customer.getId();
                Optional<Customer> customerWon = customerRepository.findById(customerId);

                if (customerWon.isPresent()) {
                    BigDecimal newBalance = new BigDecimal("75.00");
                    customer.setBalance(newBalance);
                    customerRepository.save(customer);
                }
            }
        }
    }

}
