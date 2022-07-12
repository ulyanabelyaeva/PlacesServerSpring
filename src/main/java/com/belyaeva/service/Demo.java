package com.belyaeva.service;

import com.belyaeva.domain.Author;
import com.belyaeva.domain.Publication;
import com.belyaeva.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Demo {

    private final AuthorRepository authorRepository;

    private final PublicationService publicationService;
    private final AuthorService authorService;

    @Transactional
    public void authorDemo(){

        /*System.out.println(authorRepository.findAll());

        Author author = Author.builder()
                .name("world")
                .pass("f5f5f5")
                .build();

        authorService.insert(author);

        System.out.println(authorService.getAll());*/


        System.out.println(authorService.getAll());

        authorService.update(4L, "world", "ffffff");

        System.out.println(authorService.getAll());

    }

    @Transactional
    public void publicationDemo(){

        List<Publication> publicationList = publicationService.getAll();

        for (Publication p:
             publicationList) {
            System.out.println(p);
        }

        publicationService.insert("/images/pub4.jpg", "Флоренция, Италия", "world");

        publicationList = publicationService.getAll();

        for (Publication p:
                publicationList) {
            System.out.println(p);
        }

    }
}
