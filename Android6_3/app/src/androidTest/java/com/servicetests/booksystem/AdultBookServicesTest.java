package com.servicetests.booksystem;

import android.content.Context;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.booksystem.AdultBookService;

/**
 * Created by Anita on 2016/05/12.
 */


/*
I used an intent service this will run in the background and therefor would not need to return a value
 */

public class AdultBookServicesTest extends AndroidTestCase {

    Context context = getContext();
    AdultBookService book = new AdultBookService();

    public void testAdultBookTitle()  throws Exception {
        Assert.assertEquals("Eat pray love", book.getBookTitle());
    }

    public void testAdultAuthor()  throws Exception {
        Assert.assertEquals("Elizabeth Gilbert", book.getAuthor());
    }

    public void testAdultPages()  throws Exception {
        Assert.assertEquals(300, book.getPages());
    }

}
