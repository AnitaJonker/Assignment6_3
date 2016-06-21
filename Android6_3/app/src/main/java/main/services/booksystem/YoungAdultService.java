package main.services.booksystem;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import main.domain.booksystem.impl.YoungAdult;


public class YoungAdultService extends IntentService {
    private static final String TAG = "services.booksystem";
    private static final String ACTION_FOO = "main.services.booksystem.action.FOO";
    private static final String ACTION_BAZ = "main.services.booksystem.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "main.services.booksystem.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "main.services.booksystem.extra.PARAM2";

    public YoungAdultService() {
        super("YoungAdultService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (TAG.equals(action)) {
                getBookTitle();
                getAuthor();
                getPages();
                //    handleActionFoo(param1, param2);
            } else if (TAG.equals(action)) {
                System.out.println("No service was executed");
                //       handleActionBaz(param1, param2);
            }
        }
    }


    public String getBookTitle()
    {
        YoungAdult youngAdultBook = new YoungAdult();
        return youngAdultBook.registerBook().getBookTitle();
    }

    public String getAuthor()
    {
        YoungAdult youngAdultBook = new YoungAdult();
        return youngAdultBook.registerBook().getAuthor();

    }
    public int getPages()
    {
        YoungAdult youngAdultBook = new YoungAdult();
        return youngAdultBook.registerBook().getPages();
    }

}
