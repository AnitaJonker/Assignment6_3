package main.services.admin;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import main.domain.admin.impl.RegisterCleaner;


public class CleanerService extends IntentService {

    private static final String TAG = "main.services.admin;";
    public CleanerService() {
        super("CleanerService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        getCleanerName();
        getCleanerSurname();
        getCleanerAddress();
    }


    public String getCleanerName()
    {
        RegisterCleaner registerCleaner = new RegisterCleaner();
        return registerCleaner.registerWorker().getName();
    }

    public String getCleanerSurname()
    {
        RegisterCleaner registerCleaner = new RegisterCleaner();
        return registerCleaner.registerWorker().getSurname();
    }

    public String getCleanerAddress()
    {
        RegisterCleaner registerCleaner = new RegisterCleaner();
        return registerCleaner.registerWorker().getAddress();
    }
}
