package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.Author;
import ua.com.alevel.persistence.entity.Book;

import java.util.Collection;

public interface AuthorService extends BaseService<Author> {

    Collection<Author> findAllByBook(Long bookId);
}
