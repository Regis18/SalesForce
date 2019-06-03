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
public class Common {
    /**
     * Translate date class for add days to current day.
     * @param dateKey a word for example tomorrow.
     * @return date in format.
     */
    public static String translateDate(String dateKey) {
        Date today = new Date();
        switch (dateKey) {
            case "tomorrow":
                today = DateUtils.addDays(today, 1);
                break;
            default:
                today = DateUtils.addDays(today, 7);
        }
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return format.format(today);
    }
}
