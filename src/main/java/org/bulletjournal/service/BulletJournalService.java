package org.bulletjournal.service;

import org.bulletjournal.dao.DaySummaryRepository;
import org.bulletjournal.model.DaySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author teodora.bobirneci
 */
@Service
public class BulletJournalService {

    private final DaySummaryRepository daySummaryRepository;

    @Autowired
    public BulletJournalService(DaySummaryRepository daySummaryRepository) {this.daySummaryRepository = daySummaryRepository;}

    @Transactional
    public DaySummary doSave(DaySummary daySummary){
       return daySummaryRepository.save(daySummary);
    }
}
