package com.androidlibraryv4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anita.androidlibraryv4.R;

import junit.framework.Assert;

import java.util.Set;

import main.domain.booksystem.Books;
import main.repository.booksystem.BookRepository;
import main.repository.booksystem.impl.BookRepositoryImpl;
import main.services.database.admin.InsertDB;

public class ActivityDisplayBooks extends AppCompatActivity {

Books book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_display_books);
        Bundle extras = getIntent().getExtras();
        book = (Books)extras.getSerializable("Books");

        //Display entered values
      ((TextView)findViewById(R.id.txtBookTitle)).setText(book.getBookTitle());
        ((TextView)findViewById(R.id.txtAuthor)).setText(book.getAuthor());
        ((TextView)findViewById(R.id.txtPages)).setText(book.getPages()+ " ");
        ((TextView)findViewById(R.id.txtPub)).setText(book.getPublisher());
        ((TextView)findViewById(R.id.txtISBN)).setText(book.getiSBN());

    }

public void btnSave(View v)
{
    InsertDB insertService = InsertDB.getInstance();
    insertService.addBook(this, book);
  //  Long id = InsertDB.getId();
    Intent intent = new Intent(this,ActivityShowDB.class);
   // intent.putExtra("ID", id);
    startActivity(intent);
}



}
