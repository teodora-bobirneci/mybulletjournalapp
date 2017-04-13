package org.bulletjournal.service;

import org.bulletjournal.configuration.GlobalSettings;
import org.bulletjournal.dao.DaySummaryRepository;
import org.bulletjournal.helper.DateParser;
import org.bulletjournal.model.DaySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Comparator.comparing;

/**
 * @author teodora.bobirneci
 */
@Service
public class BulletJournalServiceImpl implements BulletJournalService {

    private final DaySummaryRepository daySummaryRepository;

    @Autowired
    public BulletJournalServiceImpl(DaySummaryRepository daySummaryRepository) {this.daySummaryRepository = daySummaryRepository;}

    @Override
    @Transactional
    public DaySummary doSave(DaySummary daySummary) {
        return daySummaryRepository.save(daySummary);
    }

    @Override
    public List<DaySummary> getSummaryForWeek(Calendar calendar) throws ParseException {
        String[] daysInWeek = daysInWeek(calendar);
        List<DaySummary> summaries = daySummaryRepository.getSummaryForWeek(daysInWeek);
        addEmptyAgendasForMissingDays(daysInWeek, summaries);
        return summaries;
    }

    private String[] daysInWeek(Calendar calendar) {
        String[] days = new String[7];
        int delta = -calendar.get(DAY_OF_WEEK) + 2; //add 2 if your week start on monday
        calendar.add(DAY_OF_MONTH, delta);
        for (int i = 0; i < 7; i++) {
            days[i] = GlobalSettings.DATE_FORMAT.format(calendar.getTime());
            calendar.add(DAY_OF_MONTH, 1);
        }
        System.out.println(Arrays.toString(days));
        return days;
    }

    private void addEmptyAgendasForMissingDays(String[] daysInWeek, List<DaySummary> summaries) throws ParseException {
        HashMap<Date, DaySummary> weeklyAgenda = new HashMap<>();

        summaries.forEach(s -> weeklyAgenda.put(s.getDay(), s));

        for (String day : daysInWeek) {
            Date currentDay = DateParser.parseDate(day);
            if (!weeklyAgenda.containsKey(currentDay)) {
                summaries.add(new DaySummary(currentDay));
            }
        }
        summaries.sort(comparing(DaySummary::getDay));
    }

}
