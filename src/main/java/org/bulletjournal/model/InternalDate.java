package org.bulletjournal.model;

/**
 * In order to convert from String to dates, an intermediary model will be needed, for simplicity.
 *
 * @author Teodora Bobirneci
 */
public class InternalDate {

    private long year;
    private long month;
    private long day;

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

}
