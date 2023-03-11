package ua.com.alevel.facade;

import ua.com.alevel.dto.BookDTO;

import java.util.Collection;

public interface BookFacade {

    Collection<BookDTO> findAll();

    void create(BookDTO dto);
}
