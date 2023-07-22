package com.rest.blog.myblogapp.entity;

import com.rest.blog.myblogapp.entity.superentity.BasicDateEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "post")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BasicDateEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Builder
    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }


}
