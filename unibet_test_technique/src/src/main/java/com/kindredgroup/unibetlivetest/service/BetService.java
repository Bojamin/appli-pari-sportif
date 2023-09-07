package com.kindredgroup.unibetlivetest.service;

import com.kindredgroup.unibetlivetest.entity.Bet;

public interface BetService {

    //Méthode pour post un bet
    public Long create(Bet bet, Long id);
}
