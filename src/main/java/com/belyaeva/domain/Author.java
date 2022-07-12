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
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY - автоинкремент
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pass")
    private String pass;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Publication> publicationList;

    @Override
    public String toString() {
        List<String> pub = new ArrayList<>();
        if (publicationList != null){
            for (Publication p:
                    publicationList) {
                pub.add(String.valueOf(p.getId()));
            }
        } else {publicationList = new ArrayList<>();}

        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", publicationList='" + pub + '\'' +
                '}' + '\n';
    }
}
