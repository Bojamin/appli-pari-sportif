package com.kindredgroup.unibetlivetest.repository;

import com.kindredgroup.unibetlivetest.entity.Market;
import com.kindredgroup.unibetlivetest.entity.Selection;
import com.kindredgroup.unibetlivetest.types.SelectionResult;
import com.kindredgroup.unibetlivetest.types.SelectionState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectionRepository extends JpaRepository<Selection, Integer> {

    List<Selection> getSelectionByStateEquals(SelectionState state);

    Selection getSelectionById(Long id);

    Selection getSelectionByMarketId(Long marketId);

    List<Selection> findByResult(SelectionResult result);

    List<Selection> findByMarketId(Long id);
}
