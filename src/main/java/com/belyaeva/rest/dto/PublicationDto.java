package com.belyaeva.rest.dto;

import com.belyaeva.domain.Author;
import com.belyaeva.domain.Comment;
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
public class PublicationDto {

    private Long id;

    private String image;

    private String info;

    private String nameAuthor;

    private List<CommentDto> commentDtoList;

    public static PublicationDto toDto(Publication publication){

        List<CommentDto> commentDtoList;
        if (publication.getCommentList() != null){
            commentDtoList = publication.getCommentList()
                    .stream()
                    .map(CommentDto::toDto)
                    .collect(Collectors.toList());
        } else {commentDtoList = new ArrayList<>();}

        return new PublicationDto(
                publication.getId(),
                publication.getImage(),
                publication.getInfo(),
                publication.getAuthor().getName(),
                commentDtoList
        );
    }

}
