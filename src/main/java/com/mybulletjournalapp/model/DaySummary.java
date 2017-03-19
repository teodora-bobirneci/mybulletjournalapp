package com.mybulletjournalapp.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author teodora.bobirneci
 */
@Entity
@Table(name = "day_summaries")
public class DaySummary {
    private Long id;
    private Date day;
    private Collection<Task> tasks;
    private Collection<Appointment> appointments;

    public DaySummary() {
    }

    public DaySummary(Date day) {
        this.day = day;
        this.tasks = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DAY_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DAY")
    @Type(type="date")
    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "daySummary")
    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "daySummary")
    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Transient
    public void addTask(Task task) {
        task.setDaySummary(this);
        tasks.add(task);
    }

    @Transient
    public void addAppointment(Appointment appointment) {
        appointment.setDaySummary(this);
        appointments.add(appointment);
    }

    @Override
    public String toString() {
        return "DaySummary{" +
                "id=" + id +
                ", day=" + day +
                ", tasks=" + tasks +
                ", appointments=" + appointments +
                '}';
    }
}
