package com.servicetests.database.admin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.database.admin.ShowDB;

/**
 * Created by Anita on 2016/05/12.
 */

/*
I used a bound service to return values from the database like the amount of rows.
 */
public class ActivityShowDBTest extends AndroidTestCase {
   ShowDB myService;
    boolean isBound = false;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        Intent intent = new Intent(this.getContext(), ShowDB.class);
        this.getContext().bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ShowDB.myLocalBinder binder = ( ShowDB.myLocalBinder) service; //Converts service
            myService = binder.getService();
            System.out.println("Test the service.");
            isBound = true;
            Assert.assertTrue( myService.getSize() > 0);
        }


        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


}
