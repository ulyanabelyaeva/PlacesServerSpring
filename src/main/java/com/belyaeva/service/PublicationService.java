package com.belyaeva.service;

import com.belyaeva.domain.Publication;

import java.io.File;
import java.util.List;

public interface PublicationService {

    Publication insert(String icon, String info, String nameAuthor);

    Publication update(Long id, String info);

    List<Publication> getAll();

    Publication getById(Long id);

    void deleteById(Long id);
}
