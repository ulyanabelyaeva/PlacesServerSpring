package com.belyaeva.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY - автоинкремент
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(targetEntity = Publication.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "publication_id")
    private Publication publication;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author.getName() +
                ", publication=" + publication.getInfo() +
                '}' + '\n';
    }
}
