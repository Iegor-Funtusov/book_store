package ua.com.alevel.facade;

import ua.com.alevel.dto.AuthorDTO;

import java.util.List;

public interface AuthorFacade {

    List<AuthorDTO> findAll();
    AuthorDTO findById(Long id);
    void create(AuthorDTO dto);
    void update(Long id, AuthorDTO dto);
    void delete(Long id);
}
