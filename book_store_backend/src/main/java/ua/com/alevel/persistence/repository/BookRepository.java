package ua.com.alevel.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Author;
import ua.com.alevel.persistence.entity.Book;

import java.util.Collection;

@Repository
public interface BookRepository extends BaseRepository<Book> {

    @Query(value = "from Book b join b.authors as ba where ba.id =: authorId")
    Collection<Book> findAllByAuthors(@Param("authorId") Long Id);
}
