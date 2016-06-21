package com.servicetests.admin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.admin.SecurityService;

/*

I chose the bound service. The server can send and receive values which will be necessary for the registration process.
 */


/**
 * Created by Anita on 2016/05/11.
 */
public class SecurityServiceTest extends AndroidTestCase{
    SecurityService myService;
    boolean isBound = false;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        //Explicit intent. When you interchange between GUI's
        //Client Server
        Intent intent = new Intent(this.getContext(), SecurityService.class);
        this.getContext().bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    // Connects to the Service.
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SecurityService.myLocalBinder binder = ( SecurityService.myLocalBinder) service; //Converts service
            myService = binder.getService();
            System.out.println("Test the service.");
            isBound = true;

            //Test class SecurityService
            //Test Name
            Assert.assertEquals("Sam" , myService.getSecurityName());

            //Test Surname
            Assert.assertEquals("Smith" , myService.getSecuritySurname());

            //Test Address
            Assert.assertEquals("London" , myService.getSecurityAddress());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };



}
