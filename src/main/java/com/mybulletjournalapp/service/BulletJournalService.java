package com.mybulletjournalapp.service;

import com.mybulletjournalapp.dao.DaySummaryDao;
import com.mybulletjournalapp.model.DaySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author teodora.bobirneci
 */
@Service
public class BulletJournalService {

    @Autowired
    private DaySummaryDao daySummaryDao;

    @Transactional
    public DaySummary doSave(DaySummary daySummary){
       return daySummaryDao.save(daySummary);
    }
}
