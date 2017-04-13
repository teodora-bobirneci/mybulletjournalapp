package org.bulletjournal.dao;

import org.bulletjournal.model.DaySummary;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

/**
 * @author Teodora Bobirneci
 */
@Component
public class DaySummaryRepositoryImpl implements DaySummaryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DaySummary save(DaySummary daySummary) {
        return entityManager.merge(daySummary);
    }

    @Override
    public DaySummary findByDate(Date date) {
        return entityManager.createQuery("from DaySummary ds where ds.day = :date", DaySummary.class)
                .setParameter("date", date, DATE)
                .getResultList().get(0);
    }

}
