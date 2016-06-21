package main.services.database.admin;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import main.domain.booksystem.Books;
import main.repository.booksystem.BookRepository;
import main.repository.booksystem.impl.BookRepositoryImpl;


public class InsertDB extends IntentService {

    private static Long id;

    BookRepositoryImpl bookRepository = new BookRepositoryImpl(this.getBaseContext());
    private static final String ACTION_ADD = "main.services.database.admin.action.ADD";
    private static final String ACTION_UPDATE = "main.services.database.admin.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "main.services.database.admin.extra.ADD";
    private static final String EXTRA_UPDATE = "main.services.database.admin.extra.UPDATE";


    private static InsertDB service = null;

    public static InsertDB getInstance() {
        if (service == null)
            service = new InsertDB();
        return service;
    }

    public InsertDB() {
        super("InsertDB");
    }

    public static Long getId() {
        return id;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            if (intent != null) {
                final String action = intent.getAction();
                if (ACTION_ADD.equals(action)) {
                    final Books books = (Books)intent.getSerializableExtra(EXTRA_ADD);
                   id = saveBook(books);
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void addBook(Context context, Books books) {
        Intent intent = new Intent(context, InsertDB.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, books);
        context.startService(intent);

    }


    public void updateBook(Context context, Books books) {

        Intent intent = new Intent(context, InsertDB.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, books);
        context.startService(intent);

    }


    public void deleteBook(Context context, Books client) {

    }

    private void updateBook(Books books)
    {
        BookRepositoryImpl bookRepository= new BookRepositoryImpl(getBaseContext());
        bookRepository.update(books);
    }


    private Long saveBook(Books books) {
        BookRepositoryImpl bookRepository= new BookRepositoryImpl(getBaseContext());
        //POST and Save Local
        books = bookRepository.save(books);
        return books.getId();

    }

}




