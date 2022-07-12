package com.belyaeva.service;

import com.belyaeva.domain.Author;

import java.util.List;

public interface AuthorService {

    Author insert(String name, String pass);

    List<Author> getAll();

    Author getById(Long id);

    Author getByName(String name);

    Author update(Long id, String name, String pass);

    void deleteById(Long id);

}
