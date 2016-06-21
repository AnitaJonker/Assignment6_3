package com.servicetests.database.admin;

import android.content.Context;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import main.domain.booksystem.Books;
import main.repository.booksystem.BookRepository;
import main.repository.booksystem.impl.BookRepositoryImpl;
import main.services.database.admin.InsertDB;


/**
 * Created by Anita on 2016/05/12.
 */

/*
I used intent service to insert values since I am not receiving values back when inserting in the files.
 */

public class InsertDBTest extends AndroidTestCase{

    public void testInsert() throws Exception {


     InsertDB insertService = InsertDB.getInstance();
        Context context = getContext();
        BookRepository bookRepository = new BookRepositoryImpl(context);

        Books book = new Books.Builder()
                .bookTitle("Eat pray love")
                .author("Elizabeth Gilbert")
                .pages(300)
                .publisher("New York times")
                .iSBN("1231234")
                .build();

        insertService.addBook(this.mContext, book);

        Thread.sleep(5000);

        // READ ALL
        Set<Books> booksSetSet1 = bookRepository.findAll();
        Assert.assertTrue(booksSetSet1.size() > 0);

    }

}
