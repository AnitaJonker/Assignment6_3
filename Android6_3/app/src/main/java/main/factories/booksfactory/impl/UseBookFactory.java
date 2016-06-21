package main.factories.booksfactory.impl;

import main.domain.booksystem.Books;
import main.domain.booksystem.impl.AdultBook;
import main.domain.booksystem.impl.BookDetails;
import main.domain.booksystem.impl.Kid;
import main.domain.booksystem.impl.NonFiction;
import main.domain.booksystem.impl.Restricted;
import main.domain.booksystem.impl.YoungAdult;
import main.factories.booksfactory.BookFactory;

/**
 * Created by Anita on 2016/04/16.
 */
public class UseBookFactory implements BookFactory {


    Books book;

    public Books getBook(String bookTitle) {
        BookDetails chain = setUpChain();
       return chain.handleRequest(bookTitle);
    }
    
    public static BookDetails setUpChain(){
        BookDetails adultBook = new AdultBook();
        BookDetails kidBook = new Kid();
        BookDetails nonFiction = new NonFiction();
        BookDetails restricted = new Restricted();
        BookDetails yA = new YoungAdult();
        adultBook.setNextBookType(kidBook);
        kidBook.setNextBookType(nonFiction);
        nonFiction.setNextBookType(restricted);
        restricted.setNextBookType(yA);
        return adultBook;
    }

}

