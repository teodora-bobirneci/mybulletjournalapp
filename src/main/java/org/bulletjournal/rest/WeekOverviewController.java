package org.bulletjournal.rest;

import org.bulletjournal.helper.gson.GsonSerializer;
import org.bulletjournal.model.DaySummary;
import org.bulletjournal.service.BulletJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.Calendar;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Teodora Bobirneci
 */
@RestController
public class WeekOverviewController {

    private final BulletJournalService bulletJournalService;

    @Autowired
    public WeekOverviewController(BulletJournalService bulletJournalService) {this.bulletJournalService = bulletJournalService;}

    @GET
    @RequestMapping(value = "/weekSummary/{day}")
    @Produces(APPLICATION_JSON)
    public String getWeekSummary(@PathVariable(value = "day") String day) {
        String[] date = day.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[2]));

        List<DaySummary> weekSummary;
        try {
            weekSummary = bulletJournalService.getSummaryForWeek(calendar);
        } catch (Exception e) {
            return GsonSerializer.serializeToJson("Error: " + e.getMessage());
        }

        return GsonSerializer.serializeToJson(weekSummary.toArray());
    }


}
