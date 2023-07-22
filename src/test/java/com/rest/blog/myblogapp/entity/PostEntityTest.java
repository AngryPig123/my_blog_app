package com.rest.blog.myblogapp.entity;

import com.rest.blog.myblogapp.entity.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.rest.blog.myblogapp.utils.CommonUtil.getFormat;
import static com.rest.blog.myblogapp.utils.TextColor.BLUE;

@Slf4j
@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    //  임베디드 데이터 베이스를 사용 안한다는 선언.
class PostEntityTest extends Repository {

    private Post post;

    @BeforeEach
    void beforeEach() {
        post = Post.builder()
                .title("테스트 타이틀")
                .description("테스트 디스크립션")
                .content("테스트 콘텐트")
                .build();
        postRepository.save(post);
    }

    @Test
    void testToString() {
        Optional<Post> findPost = postRepository.findById(post.getId());
        log.info(getFormat(BLUE, "post toString = {}"), findPost.orElseThrow());
    }

}