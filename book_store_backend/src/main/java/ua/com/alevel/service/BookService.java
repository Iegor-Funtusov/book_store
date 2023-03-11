package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.Author;
import ua.com.alevel.persistence.entity.Book;

import java.util.Collection;

public interface BookService extends BaseService<Book> {

    void attachAuthorToBook(Author author);
    Collection<Book> findAllByAuthor(Author author);
}
