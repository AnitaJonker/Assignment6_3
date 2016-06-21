package com.factorytests.androidlibraryv4.testbooksystem;


import junit.framework.Assert;

import org.junit.Test;

import main.domain.booksystem.Books;
import main.factories.booksfactory.impl.UseBookFactory;

/**
 * Created by Anita on 2016/04/16.
 */
public class TestBooks {

    @Test
    public void testBookAuthor() throws Exception {
        UseBookFactory bookFactory = new UseBookFactory();
        Assert.assertEquals(bookFactory.getBook("Adult").getAuthor(),"Elizabeth Gilbert");
    }

    @Test
    public void testSetBookAuthor() throws Exception {
        Books book = new Books.Builder()
                .author("Stephen King")
                .build();
        Assert.assertEquals(book.getAuthor(),"Stephen King");

    }


}
