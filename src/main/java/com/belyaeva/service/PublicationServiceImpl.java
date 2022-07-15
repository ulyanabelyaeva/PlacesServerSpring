package com.belyaeva.service;

import com.belyaeva.domain.Author;
import com.belyaeva.domain.Comment;
import com.belyaeva.domain.Publication;
import com.belyaeva.repository.AuthorRepository;
import com.belyaeva.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService{

    private final PublicationRepository publicationRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Publication insert(String icon, String info, String nameAuthor) {

        Author author = authorRepository.findByName(nameAuthor);

        Publication publication = Publication.builder()
                .icon(icon)
                .author(author)
                .info(info)
                .build();

        /*try{
            FileInputStream fileInputStream = new FileInputStream(icon);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("/images", icon.getName()));
            byte fileContent[] = new byte[(int) icon.length()];
            fileInputStream.read(fileContent);
            fileInputStream.close();
            fileOutputStream.write(fileContent);
            fileOutputStream.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(publication);
*/
        return publicationRepository.save(publication);
    }

    @Override
    public Publication update(Long id, String info) {

        Publication old = getById(id);

        String image = old.getImage();
        Author author = old.getAuthor();
        List <Comment> commentList = old.getCommentList();

        System.out.println(old);

        Publication publication = Publication.builder()
                .id(id)
                .image(image)
                .author(author)
                .info(info)
                .commentList(commentList)
                .build();

        System.out.println(publication);

        return publicationRepository.save(publication);
    }

    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getById(Long id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }
}
