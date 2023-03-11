package ua.com.alevel.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.Author;
import ua.com.alevel.persistence.entity.Book;
import ua.com.alevel.persistence.repository.BookRepository;
import ua.com.alevel.service.BookService;

import java.util.Collection;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void attachAuthorToBook(Author author) {

    }

    @Override
    public Collection<Book> findAllByAuthor(Author author) {
        return bookRepository.findAllByAuthors(author.getId());
    }
}
