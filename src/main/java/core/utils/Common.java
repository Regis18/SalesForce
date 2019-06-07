/*
 * @(#) Common.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 *  Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 */

package core.utils;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Common Api class.
 *
 * @author Melvi Caballero
 * @version 0.0.1
 */
public final class Common {

    public static final int WEEK = 7;

    /**
     * Constructor.
     */
    private Common() {
    }

    /**
     * Translates date class for add days to current day. It is its base form.
     *
     * @param dateKey a word for example tomorrow.
     * @return date in format.
     */
    private static Date translateDateBase(final String dateKey) {
        Date today = new Date();
        int countTime = 0;
        String time = dateKey;
        if (dateKey.contains("days")) {
            countTime = Integer.parseInt(dateKey.replace(" days", ""));
            time = "days";
        } else if (dateKey.contains("weeks")) {
            countTime = Integer.parseInt(dateKey.replace(" weeks", ""));
            time = "weeks";
        }
        switch (time) {
            case "tomorrow":
                today = DateUtils.addDays(today, 1);
                break;
            case "days":
                today = DateUtils.addDays(today, countTime);
                break;
            case "one week":
                today = DateUtils.addDays(today, WEEK);
                break;
            case "weeks":
                today = DateUtils.addDays(today, WEEK * countTime);
                break;
            default:
                break;
        }
        return today;
    }

    /**
     * Translate date class for add days to current day.
     * Return in Month/Day/Year.
     *
     * @param dateKey a word for example tomorrow.
     * @return date in format.
     */
    public static String translateDate(final String dateKey) {
        Date today = translateDateBase(dateKey);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return format.format(today);
    }

    /**
     * Translate date class for add days to current day.
     * Return in Year-Month-Day.
     *
     * @param dateKey a word for example tomorrow.
     * @return date in format.
     */
    public static String translateDateAPI(final String dateKey) {
        Date today = translateDateBase(dateKey);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }
}
