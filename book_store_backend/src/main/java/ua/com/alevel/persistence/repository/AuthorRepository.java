package ua.com.alevel.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Author;

import java.util.Collection;

@Repository
public interface AuthorRepository extends BaseRepository<Author> {

//    Collection<Author> findAllByBooksBookName(String bookName);
    Collection<Author> findAllByBooksId(Long id);

    @Query(value = "from Author a join a.books as b where b.id =: bookId")
    Collection<Author> findAllByBook(@Param("bookId") Long id);

//    @Query(value = "select * from authors left join author_book ab on ab.author_id = books.id where ab.book_id = ?1", nativeQuery = true)
//    Collection<Author> findAllByBook(Long id);
}
