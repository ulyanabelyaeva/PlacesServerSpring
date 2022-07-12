package com.belyaeva.repository;

import com.belyaeva.domain.Publication;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    @Override
    @EntityGraph(attributePaths = {"author", "commentList"})
    List<Publication> findAll();

    List<Publication> findByAuthorId(int id);
}
