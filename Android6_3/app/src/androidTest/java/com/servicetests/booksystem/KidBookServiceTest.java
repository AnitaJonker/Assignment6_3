package com.servicetests.booksystem;

import android.content.Context;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.domain.booksystem.impl.Kid;
import main.services.booksystem.KidBookService;

/**
 * Created by Anita on 2016/05/12.
 */


/*
I used an intent service this will run in the background and therefor would not need to return a value
 */
public class KidBookServiceTest extends AndroidTestCase {
    Context context = getContext();
    KidBookService book = new KidBookService();

    public void testKidBookTitle()  throws Exception {
        Assert.assertEquals("Charlie and the chocolate factory.", book.getBookTitle());
    }

    public void testKidAuthor()  throws Exception {
        Assert.assertEquals("Roald Dahl", book.getAuthor());
    }

    public void testKidPages()  throws Exception {
        Assert.assertEquals(150, book.getPages());
    }

}
