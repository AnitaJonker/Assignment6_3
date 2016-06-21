package main.domain.booksystem.impl;

import main.domain.booksystem.Books;
import main.domain.booksystem.RegisterBook;

/**
 * Created by Anita on 2016/04/16.
 */
public class YoungAdult extends BookDetails implements RegisterBook {

    public Books registerBook()
    {
        Books yA = new Books.Builder()
                .bookTitle("The fault in our stars.")
                .author("John Green")
                .pages(340)
                .publisher("Dutton Penguin")
                .build();
        return yA;

    }
    public Books handleRequest(String request) {
        if (request.equalsIgnoreCase("YA")) {
            return registerBook();
        } else {
            if (request != null) {
                return nextType.handleRequest(request);
            }
            return null;
        }
    }

}
