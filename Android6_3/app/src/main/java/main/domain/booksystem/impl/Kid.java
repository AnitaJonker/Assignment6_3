package main.domain.booksystem.impl;


import main.domain.booksystem.Books;
import main.domain.booksystem.RegisterBook;

/**
 * Created by student on 2016/03/31.
 */
public class Kid extends BookDetails implements RegisterBook {
    public Books registerBook()
    {
        Books kidsBook = new Books.Builder()
                .bookTitle("Charlie and the chocolate factory.")
                .author("Roald Dahl")
                .pages(150)
                .publisher("Penguin Books")
                .build();
        return kidsBook;

    }
    public Books handleRequest(String request) {
        if(request.equalsIgnoreCase("Kid")){
            return registerBook();
        }else{
            if (request!=null) {
                return nextType.handleRequest(request);
            }
            return null;
        }
    }
}
