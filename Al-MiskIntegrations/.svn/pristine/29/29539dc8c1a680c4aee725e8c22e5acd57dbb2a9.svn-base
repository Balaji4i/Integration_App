/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.al.miskintegrations;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author gautham.r
 */
public class PayloadUtility {

    private String createdDate;
    private String expiredDate;
    protected String test_UserName = "ERP_user";
    protected String test_Password = "welcome@4i";
    protected String test_Encoded = "fvHY1x86NR06HuudWKA+cw==";
    protected String prod_UserName = "ERP_user";
    protected String prod_Password = "welcome@4i";
    protected String prod_Encoded = "fvHY1x86NR06HuudWKA+cw==";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
    Date date;

    public String getCreatedDate() {

        date = new Date();
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        createdDate = dateFormat.format(new Date());
        return createdDate;
    }

    public String getExpiredDate() {
        date = new Date();
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        expiredDate = dateFormat.format(DateUtils.addMinutes(date, 2));
        return expiredDate;
    }

}
