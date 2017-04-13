package org.bulletjournal.service;

import org.bulletjournal.model.DaySummary;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

/**
 * @author Teodora Bobirneci
 */
public interface BulletJournalService {

    DaySummary doSave(DaySummary daySummary);

    List<DaySummary> getSummaryForWeek(Calendar calendar) throws ParseException;

}
