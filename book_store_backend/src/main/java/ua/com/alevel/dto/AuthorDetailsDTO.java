package ua.com.alevel.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.entity.Author;
import ua.com.alevel.persistence.entity.Book;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
public class AuthorDetailsDTO extends AuthorDTO {

    private Collection<BookDTO> books;

    public AuthorDetailsDTO(Author author) {
        super(author);
        if (CollectionUtils.isNotEmpty(author.getBooks())) {
            Set<Book> bookSet = author.getBooks();
            this.books = bookSet
                    .stream()
                    .map(BookDTO::new)
                    .toList();
        }
    }
}
