package com.servicetests.admin;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.admin.CleanerService;


/**
 * Created by Anita on 2016/05/11.
 */

/*

I chose the intent service since this service is not needed to return a value.

 */

public class CleanerServiceTest extends AndroidTestCase {
    Context context = getContext();
    CleanerService cleaner = new CleanerService();

    public void testCleanerName() throws Exception {
        Assert.assertEquals("Lana", cleaner.getCleanerName());
    }


    public void testCleanerSurname() throws Exception {
        Assert.assertEquals("De Waal", cleaner.getCleanerSurname());
    }


    public void testCleanerAddress() throws Exception {
        Assert.assertEquals("Barbarossa str 4", cleaner.getCleanerAddress());
    }


}


