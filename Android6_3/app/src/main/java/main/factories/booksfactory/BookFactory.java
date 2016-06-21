package main.factories.booksfactory;

/**
 * Created by Anita on 2016/04/16.
 */

import main.domain.booksystem.Books;

public interface BookFactory {
    Books getBook(String bookTitle);
}
