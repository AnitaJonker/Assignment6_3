package main.services.admin;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import main.domain.admin.impl.RegisterSecurity;
/*

I chose the bound service. The server can send and receive values which will be neccesarry for the registration process

 */

/**
 * Created by Anita on 2016/05/11.
 */
public class SecurityService extends Service {

    private String name = "name";
    private RegisterSecurity registerSecurity = new RegisterSecurity();
    private final IBinder securityBind = new myLocalBinder();

    public SecurityService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return securityBind;
    }

    public class myLocalBinder extends Binder
    {
        public SecurityService getService()
        {
            return SecurityService.this;
        }
    }

    public String getSecurityName()
    {
        return registerSecurity.registerWorker().getName();
    }

    public String getSecuritySurname()
    {
        return registerSecurity.registerWorker().getSurname();
    }

    public String getSecurityAddress()
    {
        return registerSecurity.registerWorker().getAddress();
    }
}
