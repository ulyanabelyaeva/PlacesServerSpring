package com.belyaeva.service;

import com.belyaeva.domain.Comment;
import com.belyaeva.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final AuthorService authorService;
    private final PublicationService publicationService;

    @Override
    public List<Comment> getAllByPublicationId(Long publicationId) {
        return commentRepository.findByPublicationId(publicationId);
    }

    @Override
    public Comment insert(String content, String nameAuthor, Long publicationId) {

        Comment comment = Comment.builder()
                .content(content)
                .author(authorService.getByName(nameAuthor))
                .publication(publicationService.getById(publicationId))
                .build();

        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
