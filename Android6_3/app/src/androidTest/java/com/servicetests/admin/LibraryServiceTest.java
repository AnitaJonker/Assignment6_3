package com.servicetests.admin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.admin.LibraryService;

/**
 * Created by Anita on 2016/05/11.
 */



//I chose the bound service. The server can send and receive values which will be necessary for the registration process

public class LibraryServiceTest extends AndroidTestCase{
    LibraryService myService;
    boolean isBound = false;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        //Explicit intent. When you interchange between GUI's
        //Client Server
        Intent intent = new Intent(this.getContext(), LibraryService.class);
        this.getContext().bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    // Connects to the Service.
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LibraryService.myLocalBinder binder = ( LibraryService.myLocalBinder) service; //Converts service
            myService = binder.getService();
            System.out.println("Test the service.");
            isBound = true;


            //Test class RegisterLibrarian
            //Test Name
            Assert.assertEquals("Anita" , myService.getLibrarianName());

            //Test Surname
            Assert.assertEquals("Jonker" , myService.getLibrarianSurname());

            //Test Address
            Assert.assertEquals("Almeria str4" , myService.getLibrarianAddress());

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
