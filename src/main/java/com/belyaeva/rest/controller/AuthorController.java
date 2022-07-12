package com.belyaeva.rest.controller;

import com.belyaeva.domain.Author;
import com.belyaeva.rest.dto.AuthorDto;
import com.belyaeva.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author")
    public List<AuthorDto> getAllAuthor(){

        return authorService.getAll()
                .stream()
                .map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id){
        Author author = authorService.getById(id);
        return AuthorDto.toDto(author);
    }

    @PostMapping("/author")
    public AuthorDto insertAuthor (
            @RequestParam String nameAuthor,
            @RequestParam String passAuthor){

        Author author = authorService.insert(nameAuthor, passAuthor);
        return AuthorDto.toDto(author);
    }

    @PutMapping("/author/{id}")
    public AuthorDto updateAuthor(
            @PathVariable Long id,
            @RequestParam String nameAuthor,
            @RequestParam String passAuthor){

        Author author = authorService.update(id, nameAuthor, passAuthor);
        return AuthorDto.toDto(author);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteById(id);
    }

}
