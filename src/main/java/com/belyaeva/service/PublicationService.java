package com.belyaeva.service;

import com.belyaeva.domain.Publication;

import java.util.List;

public interface PublicationService {

    Publication insert(String image, String info, String nameAuthor);

    Publication update(Long id, String info);

    List<Publication> getAll();

    Publication getById(Long id);

    void deleteById(Long id);
}
