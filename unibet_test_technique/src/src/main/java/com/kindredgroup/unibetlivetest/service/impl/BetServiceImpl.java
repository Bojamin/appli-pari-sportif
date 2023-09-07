package com.kindredgroup.unibetlivetest.service.impl;

import com.kindredgroup.unibetlivetest.entity.Bet;
import com.kindredgroup.unibetlivetest.entity.Customer;
import com.kindredgroup.unibetlivetest.repository.BetRepository;
import com.kindredgroup.unibetlivetest.repository.CustomerRepository;
import com.kindredgroup.unibetlivetest.repository.SelectionRepository;
import com.kindredgroup.unibetlivetest.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    BetRepository betRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SelectionRepository selectionRepository;

    //Méthode pour post un bet
    @Override
    public Long create(Bet bet, Long id) {
        //Vu qu'il n'y a qu'un utilisateur enregistré je le cherche en dur via son pseudo + la méthode déjà existante était de type Optionnal je vérifie donc la présence du customer.
        Optional<Customer> optionnalCustomer = customerRepository.getCustomerByPseudo("unibest");
        if (optionnalCustomer.isPresent()) {
            bet.setCustomer(optionnalCustomer.get());
        } else {
            return null;
        }
        bet.setSelection(selectionRepository.getSelectionById(id));
        return betRepository.save(bet).getId();
   }
}
