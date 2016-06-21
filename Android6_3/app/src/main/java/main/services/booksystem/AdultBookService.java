package main.services.booksystem;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import main.domain.admin.impl.RegisterCleaner;
import main.domain.booksystem.impl.AdultBook;

public class AdultBookService extends IntentService {
    private static final String TAG = "services.booksystem";
    private static final String ACTION_FOO = "main.services.booksystem.action.FOO";
    private static final String ACTION_BAZ = "main.services.booksystem.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "main.services.booksystem.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "main.services.booksystem.extra.PARAM2";

    public AdultBookService() {
        super("AdultBookService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (TAG.equals(action)) {
            //    handleActionFoo(param1, param2);
            } else if (TAG.equals(action)) {
                System.out.println("No service was executed");
         //       handleActionBaz(param1, param2);
            }
        }
    }


    public String getBookTitle()
    {
        AdultBook registerBook = new AdultBook();
        return registerBook.registerBook().getBookTitle();

    }

    public String getAuthor()
    {
        AdultBook registerBook = new AdultBook();
        return registerBook.registerBook().getAuthor();

    }

    public int getPages()
    {
        AdultBook registerBook = new AdultBook();
        return registerBook.registerBook().getPages();

    }



}
