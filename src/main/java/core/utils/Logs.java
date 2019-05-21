package core.utils;
/**
 * @(#)Logs.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

 import org.apache.log4j.Level;
 import org.apache.log4j.Logger;
 import org.apache.log4j.PropertyConfigurator;
/**
 * Logs.
 * @author Melvi Caballero
 * @version 0.0.1
 */
public final class Logs {
    private static final Logger LOGGER = Logger.getLogger(Logs.class);
    private static Logs instance = null;

    /**
     * Is the private constructor of our Singleton class.
     */
    private Logs() {
        super();
    }

    /**
     * A instance is created at the beginning and.
     * if it just was created, returns just the object created.
     * It has a log4j.properties to config the syntax's logs. That
     * file is in the folder resources.
     *
     * @return Logger
     */
    public static Logs getInstance() {
        if (instance == null) {
            instance = new Logs();
            PropertyConfigurator.configure("../SalesForce/log4j.properties");
            LOGGER.setLevel(Level.ALL);
        }
        return instance;
    }

    /**
     * @return Logger log to do our loggers
     */
    public Logger getLog() {
        return LOGGER;
    }
}
