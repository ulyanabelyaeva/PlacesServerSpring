package com.belyaeva.service;

import com.belyaeva.domain.Author;
import com.belyaeva.domain.Comment;
import com.belyaeva.domain.Publication;

import java.util.List;

public interface CommentService {

    List<Comment> getAllByPublicationId(Long publicationId);

    Comment insert(String content, String nameAuthor, Long publicationId);

    void deleteById(Long id);

}
