package com.rest.blog.myblogapp.entity;

import com.rest.blog.myblogapp.entity.superentity.BasicDateEntity;
import com.rest.blog.myblogapp.payload.PostDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(
        name = "post",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}    //  title 에 유니크 제약 조건 추가.
)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BasicDateEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Post updatePost(PostDto postDto) {
        return Post.builder()
                .title(postDto.getTitle())
                .description(postDto.getDescription())
                .content(postDto.getContent())
                .build();
    }

    public PostDto toDto() {
        return PostDto.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .content(this.content)
                .createdDate(super.createdDate)
                .updatedDate(super.updatedDate)
                .build();
    }

}
