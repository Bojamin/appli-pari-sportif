package com.kindredgroup.unibetlivetest.service.impl;

import com.kindredgroup.unibetlivetest.entity.Selection;
import com.kindredgroup.unibetlivetest.repository.SelectionRepository;
import com.kindredgroup.unibetlivetest.service.SelectionResultService;
import com.kindredgroup.unibetlivetest.types.SelectionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionResultImpl implements SelectionResultService {

    @Autowired
    SelectionRepository selectionResultRepository;

    @Override
    public void update(Long identifiant) {
        Selection selectionWon = selectionResultRepository.getSelectionById(identifiant);
        selectionWon.setResult(SelectionResult.WON);
        selectionResultRepository.save(selectionWon);
    }
}
