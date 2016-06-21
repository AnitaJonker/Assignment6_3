package com.servicetests.booksystem;

import android.content.Context;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.booksystem.YoungAdultService;

/**
 * Created by Anita on 2016/05/12.
 */

/*
I used an intent service this will run in the background and therefor would not need to return a value
*/


public class YoungAdultServiceTest extends AndroidTestCase {

    Context context = getContext();
    YoungAdultService book = new YoungAdultService();

    public void testYoungAdultBookTitle()  throws Exception {
        Assert.assertEquals("The fault in our stars.", book.getBookTitle());
    }

    public void testYoungAdultAuthor()  throws Exception {
        Assert.assertEquals("John Green", book.getAuthor());
    }

    public void testYoungAdultPages()  throws Exception {
        Assert.assertEquals(340, book.getPages());
    }

}
