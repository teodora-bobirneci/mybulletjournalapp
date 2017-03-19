package com.mybulletjournalapp.model;

import com.google.common.base.Joiner;

import javax.persistence.*;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

/**
 * @author teodora.bobirneci
 */
@Entity
@Table(name = "appointments")
public class Appointment {
    private Long id;
    private String title;
    private String description;
    private String participantsCSV;
    private DaySummary daySummary;

    public Appointment() {
    }

    public Appointment(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPOINTMENT_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    public List<String> getParticipants() {
        return newArrayList(participantsCSV.split(","));
    }

    @Transient
    public void setParticipants(List<String> participants) {
        this.participantsCSV = Joiner.on(',').join(participants.stream().map(String::trim).collect(toList()));
    }

    @Column(name = "PARTICIPANTS")
    private String getParticipantsCSV() {
        return participantsCSV;
    }

    private void setParticipantsCSV(String participantsCSV) {
        this.participantsCSV = participantsCSV;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DAY_ID", nullable = false)
    public DaySummary getDaySummary() {
        return daySummary;
    }

    public void setDaySummary(DaySummary daySummary) {
        this.daySummary = daySummary;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", participantsCSV='" + participantsCSV + '\'' +
                '}';
    }
}
