package com.belyaeva.rest.dto;


import com.belyaeva.domain.Author;
import com.belyaeva.domain.Publication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    private String name;

    private String pass;

    private List<PublicationDto> publicationDtoList;

    public static AuthorDto toDto(Author author){

        List<PublicationDto> publicationDtoList;
        if (author.getPublicationList() != null){
            publicationDtoList = author.getPublicationList()
                    .stream()
                    .map(PublicationDto::toDto)
                    .collect(Collectors.toList());
        } else {publicationDtoList = new ArrayList<>();}

        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getPass(),
                publicationDtoList
        );
    }

}
