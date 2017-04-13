package org.bulletjournal.model;

import org.bulletjournal.helper.gson.GsonExclude;

import javax.persistence.*;

/**
 * @author teodora.bobirneci
 */
@Entity
@Table(name = "tasks")
public class Task {
    private Integer id;
    private String title;
    private String description;
    @GsonExclude
    private DaySummary daySummary;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TASK_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
