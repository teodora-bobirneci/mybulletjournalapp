package org.bulletjournal.helper;

import org.bulletjournal.configuration.GlobalSettings;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Teodora Bobirneci
 */
public class DateParser {

    public static Date parseDate(String str) throws ParseException {
        return GlobalSettings.DATE_FORMAT.parse(str);
    }

}
