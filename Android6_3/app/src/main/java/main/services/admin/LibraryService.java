package main.services.admin;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import main.domain.admin.impl.RegisterLibrarian;

/*

I chose the bound service. The server can send and receive values which will be neccesarry for the registration process

 */




/**
 * Created by Anita on 2016/05/11.
 */
public class LibraryService extends Service {

    private String name = "name";
    private final IBinder libraryBind = new myLocalBinder();
    public LibraryService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return libraryBind;

    }

    public class myLocalBinder extends Binder
    {
        public LibraryService getService()
        {
            return LibraryService.this;
        }

    }

    public String getLibrarianName()
    {
        RegisterLibrarian registerLibrarian = new RegisterLibrarian();
        return registerLibrarian.registerWorker().getName();
    }

    public String getLibrarianSurname()
    {
        RegisterLibrarian registerLibrarian = new RegisterLibrarian();
        return registerLibrarian.registerWorker().getSurname();
    }

    public String getLibrarianAddress()
    {
        RegisterLibrarian registerLibrarian = new RegisterLibrarian();
        return registerLibrarian.registerWorker().getAddress();
    }

}
