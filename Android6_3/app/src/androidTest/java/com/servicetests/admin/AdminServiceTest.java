package com.servicetests.admin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.admin.AdminService;


/*
I chose the bound service. The server can send and receive values which will be neccesarry for the registration process
 */


/**
 * Created by Anita on 2016/05/09.
 */
public class AdminServiceTest extends AndroidTestCase{

    AdminService myService;
    boolean isBound = false;

    @Override
    public void setUp() throws Exception {
    super.setUp();

    //Explicit intent. When you interchange between GUI's
        //Client Server
        Intent intent = new Intent(this.getContext(), AdminService.class);
        this.getContext().bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    // Connects to the Service.
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AdminService.myLocalBinder binder = ( AdminService.myLocalBinder) service; //Converts service
            myService = binder.getService();
            System.out.println("Test the service.");
            isBound = true;

            //Test class RegisterCleaner
            Assert.assertEquals("Lana", myService.getCleanerName());

            //Test class RegisterLibrarian
            Assert.assertEquals("Anita" , myService.getLibrarianName());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        isBound = false;
        }
    };








}
