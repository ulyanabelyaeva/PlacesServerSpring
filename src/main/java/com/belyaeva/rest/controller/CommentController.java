package com.belyaeva.rest.controller;

import com.belyaeva.domain.Comment;
import com.belyaeva.rest.dto.CommentDto;
import com.belyaeva.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/{id}")
    public List<CommentDto> getAllCommentByPublicationId(@PathVariable Long id){
        return commentService.getAllByPublicationId(id)
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/comment")
    public CommentDto insertComment(
            @RequestParam String content,
            @RequestParam String nameAuthor,
            @RequestParam Long publicationId
    ){

        Comment comment = commentService.insert(content, nameAuthor, publicationId);

        return CommentDto.toDto(comment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteById(id);
    }

}
