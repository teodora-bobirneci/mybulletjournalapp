package org.bulletjournal.dao;

import org.bulletjournal.model.DaySummary;

import java.util.Date;

/**
 * @author teodora.bobirneci
 */
public interface DaySummaryRepository {

    DaySummary findByDate(Date date);

    DaySummary save(DaySummary daySummary);
}
