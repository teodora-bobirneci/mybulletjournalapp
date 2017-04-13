package org.bulletjournal.dao;

import org.bulletjournal.model.DaySummary;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author teodora.bobirneci
 */
public interface DaySummaryRepository {

    DaySummary findByDate(Date date);

    DaySummary save(DaySummary daySummary);

    List<DaySummary> getSummaryForWeek(String[] calendar) throws ParseException;

}
