package com.mybulletjournalapp.rest;

import com.mybulletjournalapp.model.Appointment;
import com.mybulletjournalapp.model.DaySummary;
import com.mybulletjournalapp.model.Task;
import com.mybulletjournalapp.service.BulletJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * @author teodora.bobirneci
 */
@RestController
public class WebController {
    @Autowired
    private BulletJournalService bulletJournalService;

    @RequestMapping("/test")
    @Transactional
    public String index() {
        try {
            Calendar yesterday = Calendar.getInstance();
            yesterday.add(Calendar.DATE, -1);
            yesterday.set(Calendar.HOUR_OF_DAY, 8);

            DaySummary yesterdaysSummary = new DaySummary(yesterday.getTime());


            Task task = new Task("Polita Pad", "Pentru apartament: polita PAD + asigurarea obligatorie");


            Appointment appointment1 = new Appointment("Cafea cu fetele", "La Cafeneaua noastra");
            Appointment appointment = new Appointment("Contabilitate", "bilant 2016");

            yesterdaysSummary.addTask(task);
            yesterdaysSummary.addAppointment(appointment1);
            yesterdaysSummary.addAppointment(appointment);

            yesterdaysSummary = bulletJournalService.doSave(yesterdaysSummary);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Greetings from Spring Boot!";
    }

}