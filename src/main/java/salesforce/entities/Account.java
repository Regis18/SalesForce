/*
 * @(#) Account.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.entities;

import java.util.Map;

/**
 * Account.
 * @author Luis Guardia.
 */
public class Account {
    private String name;

    /**
     * Get Account name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Account type.
     * @param name *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the values of an Account.
     * @param accountInformation *
     */
    public void setInformation(final Map<String, String> accountInformation) {
        setName(accountInformation.get("Account name"));
    }
}
