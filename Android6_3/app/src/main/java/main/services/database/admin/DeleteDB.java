package main.services.database.admin;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import main.domain.admin.Worker;
import main.repository.admin.impl.WorkerRepositoryImpl;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DeleteDB extends IntentService {
    WorkerRepositoryImpl repo = new WorkerRepositoryImpl(this.getApplicationContext());


    private static final String TAG ="services.database";
    public DeleteDB() {
        super("DeleteDB");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        repo.deleteAll();
    }


}
