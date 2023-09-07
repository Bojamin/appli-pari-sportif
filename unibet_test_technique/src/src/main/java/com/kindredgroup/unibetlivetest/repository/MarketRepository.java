package com.kindredgroup.unibetlivetest.repository;

import com.kindredgroup.unibetlivetest.entity.Bet;
import com.kindredgroup.unibetlivetest.entity.Event;
import com.kindredgroup.unibetlivetest.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MarketRepository extends JpaRepository<Market, Integer> {

    List<Market> findByEventId(Long id);
}
