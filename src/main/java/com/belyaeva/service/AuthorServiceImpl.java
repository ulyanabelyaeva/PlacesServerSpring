package com.belyaeva.service;

import com.belyaeva.domain.Author;
import com.belyaeva.domain.Publication;
import com.belyaeva.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Override
    public Author insert(String name, String pass) {

        Author author = Author.builder()
                .name(name)
                .pass(pass)
                .build();

        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Author getByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Author update(Long id, String name, String pass) {

        Author old = authorRepository.findById(id).get();
        List<Publication> publicationList = old.getPublicationList();

        Author author = Author.builder()
                .id(id)
                .name(name)
                .pass(pass)
                .publicationList(publicationList)
                .build();

        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
