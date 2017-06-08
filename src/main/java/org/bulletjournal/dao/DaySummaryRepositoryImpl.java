package org.bulletjournal.dao;

import org.bulletjournal.model.DaySummary;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;
import static org.bulletjournal.helper.DateParser.parseDate;

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
        List<DaySummary> daySummaries = entityManager.createQuery("from DaySummary ds where ds.day = :date", DaySummary.class)
                .setParameter("date", date, DATE)
                .getResultList();
        if (!daySummaries.isEmpty()) {
            return daySummaries.get(0);
        } else {
            return new DaySummary(Calendar.getInstance().getTime());
        }
    }

    @Override
    public List<DaySummary> getSummaryForWeek(String[] daysFromGivenWeek) throws ParseException {
        return entityManager.createQuery("from DaySummary ds where ds.day BETWEEN :startDate" +
                " and :endDate ", DaySummary.class)
                .setParameter("startDate", parseDate(daysFromGivenWeek[0]), DATE)
                .setParameter("endDate", parseDate(daysFromGivenWeek[6]), DATE).getResultList();
    }

}
