package main.services.admin;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import main.domain.admin.impl.RegisterCleaner;
import main.domain.admin.impl.RegisterLibrarian;


/*

I chose the bound service. The server can send and receive values which will be neccesarry for the registration process
 */

public class AdminService extends Service {

    private String name = "name";
    private final IBinder adminBind = new myLocalBinder();

    public AdminService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return adminBind;
    }

    public class myLocalBinder extends Binder
    {
        public  AdminService getService(){
            return AdminService.this;
        }
    }

    public String getCleanerName()
    {
        RegisterCleaner registerCleaner = new RegisterCleaner();
        return registerCleaner.registerWorker().getName();
    }

    public String getLibrarianName()
    {
        RegisterLibrarian registerLibrarian = new RegisterLibrarian();
        return registerLibrarian.registerWorker().getName();
    }


}
