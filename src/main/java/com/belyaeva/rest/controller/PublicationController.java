package com.belyaeva.rest.controller;

import com.belyaeva.domain.Publication;
import com.belyaeva.rest.dto.PublicationDto;
import com.belyaeva.service.AuthorService;
import com.belyaeva.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;
    private final AuthorService authorService;

    @GetMapping("/publication")
    public List<PublicationDto> getAllPublication(){
        return publicationService.getAll()
                .stream()
                .map(PublicationDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/publication/{id}")
    public PublicationDto getPublicationById(@PathVariable Long id){

        Publication publication = publicationService.getById(id);
        return PublicationDto.toDto(publication);
    }

    @PostMapping("/publication")
    public PublicationDto insertPublication(
            @RequestParam String image,
            @RequestParam String info,
            @RequestParam String nameAuthor){

        Publication publication = publicationService.insert(image, info, nameAuthor);
        return PublicationDto.toDto(publication);
    }

    @PutMapping("/publication/{id}")
    public PublicationDto updatePublication(
            @PathVariable Long id,
            @RequestParam String info){

        Publication publication = publicationService.update(id, info);
        return PublicationDto.toDto(publication);
    }

    @DeleteMapping("/publication/{id}")
    public void deletePublication(@PathVariable Long id){
        publicationService.deleteById(id);
    }

}
