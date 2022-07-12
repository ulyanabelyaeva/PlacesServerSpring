package com.belyaeva.rest.dto;

import com.belyaeva.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private Long id;

    private String content;

    private String nameAuthor;

    public static CommentDto toDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.getContent(),
                comment.getAuthor().getName()
        );
    }

}
