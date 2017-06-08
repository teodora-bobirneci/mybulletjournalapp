package org.bulletjournal.rest;


import org.bulletjournal.dao.DaySummaryRepository;
import org.bulletjournal.helper.DateParser;
import org.bulletjournal.helper.gson.GsonSerializer;
import org.bulletjournal.model.DaySummary;
import org.bulletjournal.model.Task;
import org.bulletjournal.rest.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author teodora.bobirneci
 */
@RestController
public class MyDayController {
    private final DaySummaryRepository daySummaryRepository;

    @Autowired
    public MyDayController(DaySummaryRepository daySummaryRepository) {this.daySummaryRepository = daySummaryRepository;}

    @GET
    @RequestMapping(value = "/day_summary/{day}")
    @Produces(APPLICATION_JSON)
    public String getDaySummary(@PathVariable(value = "day") String day) {
        validateDateFormat(day);
        try {
            String[] date = day.split("-");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[2]));
            Date parsed = calendar.getTime();

            return GsonSerializer.serializeToJson(daySummaryRepository.findByDate(parsed));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "We were unable to retrieve your data!";
    }

    private void validateDateFormat(String day) {

    }

    @PostMapping("/addTask")
//    @Consumes(APPLICATION_FORM_URLENCODED)
//    @Produces(MediaType.TEXT_PLAIN)
    public String addTask(@ModelAttribute TaskDTO task) {
        DaySummary daySummary;
        try {
            daySummary = daySummaryRepository.findByDate(DateParser.parseDate(task.getDate()));
        } catch (ParseException e) {
            return "Invalid date format!";
        }
        daySummary.addTask(new Task(task.getTitle(), task.getDescription()));
        daySummaryRepository.save(daySummary);
        return "OK";
    }

}