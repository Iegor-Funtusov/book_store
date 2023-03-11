package ua.com.alevel.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.entity.Author;
import ua.com.alevel.persistence.entity.Book;
import ua.com.alevel.persistence.entity.Publisher;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class BookDTO {

    private Long id;
    private String bookName;
    private String description;
    private String imageUrl;
    private Integer pageSize;
    private Integer publishDate;
    private String price;
    private Integer quantity;
    private String publisher;
    private Collection<String> authors;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.bookName = book.getBookName();
        this.description = book.getDescription();
        this.imageUrl = book.getImageUrl();
        this.pageSize = book.getPageSize();
        this.publishDate = book.getPublishDate();
        this.price = book.getPrice().toString();
        this.quantity = book.getQuantity();
        Publisher publisher1 = book.getPublisher();
        if (publisher1 != null) {
            this.publisher = publisher1.getName();
        }
        Set<Author> authors1 = book.getAuthors();
        if (CollectionUtils.isNotEmpty(authors1)) {
            List<String> names = authors1
                    .stream()
                    .map(author -> author.getFirstName().concat(" ").concat(author.getLastName()))
                    .toList();
            this.authors = names;
        }
    }
}
