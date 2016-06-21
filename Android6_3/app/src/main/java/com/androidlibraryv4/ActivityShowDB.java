package com.androidlibraryv4;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anita.androidlibraryv4.*;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Set;

import main.domain.booksystem.Books;
import main.repository.booksystem.BookRepository;
import main.repository.booksystem.impl.BookRepositoryImpl;
import main.services.database.admin.ShowDB;

public class ActivityShowDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_db);
        final TextView lblList = (TextView) findViewById(R.id.txtDisplay);
        BookRepositoryImpl repo = new BookRepositoryImpl(this.getBaseContext());
        Set<Books> bookList = repo.findAll();
        ArrayList<Books> list = new ArrayList<>(bookList);
        int listSize = bookList.size();


        for (int x = 0; x < bookList.size(); x++) {
            lblList.append("\nBook Title: " + list.get(x).getBookTitle() +
                            "\nAuthor: " + list.get(x).getAuthor() +
                    "\nPages: " + list.get(x).getPages() +
                    "\nPublisher: " + list.get(x).getPublisher() +
                    "\nISBN: " + list.get(x).getiSBN() + "\n"
            );
        }
    }

    public void onClickHome(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

