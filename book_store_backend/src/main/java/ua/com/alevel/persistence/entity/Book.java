package ua.com.alevel.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "page_size")
    private Integer pageSize;

    @Column(name = "publish_date")
    private Integer publishDate;

    @Column(precision = 7, scale = 2)
    private BigDecimal price;

    private Integer quantity;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    public Book() {
        super();
        this.price = new BigDecimal("00.00");
        this.quantity = 0;
        this.authors = new HashSet<>();
    }
}
