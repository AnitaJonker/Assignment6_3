package com.servicetests.booksystem;

import android.content.Context;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.booksystem.RestrictedBookService;

/*
I used an intent service this will run in the background and therefor would not need to return a value
 */

public class RestrictedBookServiceTest extends AndroidTestCase{
    Context context = getContext();
    RestrictedBookService book = new RestrictedBookService();

    public void testRestrictedBookTitle()  throws Exception {
        Assert.assertEquals("Charlie and the chocolate factory.", book.getBookTitle());
    }

    public void testRestrictedAuthor()  throws Exception {
        Assert.assertEquals("Roald Dahl", book.getAuthor());
    }

    public void testRestrictedPages()  throws Exception {
        Assert.assertEquals(150, book.getPages());
    }
}
