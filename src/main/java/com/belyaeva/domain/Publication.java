package com.belyaeva.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY - автоинкремент
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "info")
    private String info;

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.LAZY) //много публикаций - один пользователь
    // targetEntity - сущность, с которой связываемся, FetchType.LAZY - если к этому полю нет обращения, то запрос на таблицу user не делается
    // FetchType.EAGER - вытаскивать все
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publication")
    private List<Comment> commentList;

    @Override
    public String toString() {

        List<String> com = new ArrayList<>();

        if (commentList != null){
            for (Comment p:
                    commentList) {
                com.add(p.getContent());
            }
        } else {commentList = new ArrayList<>();}


        return "Publication{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                ", author=" + author.getName() +
                ", commentList=" + com +
                '}' + '\n';
    }
}
