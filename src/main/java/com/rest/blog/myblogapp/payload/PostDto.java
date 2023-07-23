package com.rest.blog.myblogapp.payload;

import com.rest.blog.myblogapp.entity.Post;
import com.rest.blog.myblogapp.payload.superdto.BasicDateDto;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PostDto extends BasicDateDto {

    private Long id;
    private String title;
    private String description;
    private String content;

    @Builder
    public PostDto(Long id, String title, String description, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        super.createdDate = createdDate;
        super.updatedDate = updatedDate;
    }

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .description(this.description)
                .build();
    }

}
