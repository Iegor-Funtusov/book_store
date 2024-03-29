package ua.com.alevel.dto;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.entity.Book;

@Getter
@Setter
public class BookDetailsDTO extends BookDTO {

    private String description;

    public BookDetailsDTO(Book book) {
        super(book);
        this.description = book.getDescription();
    }
}
