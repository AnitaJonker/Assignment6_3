package main.services.booksystem;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import main.domain.booksystem.impl.Restricted;
import main.domain.booksystem.impl.YoungAdult;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RestrictedBookService extends IntentService {
    private static final String TAG = "services.booksystem";
    private static final String ACTION_FOO = "main.services.booksystem.action.FOO";
    private static final String ACTION_BAZ = "main.services.booksystem.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "main.services.booksystem.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "main.services.booksystem.extra.PARAM2";

    public RestrictedBookService() {
        super("RestrictedBookService");
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
        Restricted restrictedBook = new Restricted();
        return restrictedBook.registerBook().getBookTitle();
    }

    public String getAuthor()
    {
        Restricted restrictedBook = new Restricted();
        return restrictedBook.registerBook().getAuthor();

    }
    public int getPages()
    {
        Restricted restrictedBook = new Restricted();
        return restrictedBook.registerBook().getPages();
    }

}
