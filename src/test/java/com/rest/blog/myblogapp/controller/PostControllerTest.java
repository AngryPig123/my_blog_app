package com.rest.blog.myblogapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.blog.myblogapp.payload.PostDto;
import com.rest.blog.myblogapp.repository.PostRepository;
import com.rest.blog.myblogapp.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    private PostDto postDto;

    private String parameter;

    @BeforeEach
    void beforeEach() throws Exception {
        postDto = PostDto.builder()
                .title("테스트 타이틀")
                .description("테스트 디스크립션")
                .content("테스트 콘텐츠")
                .build();
        parameter = objectMapper.writeValueAsString(postDto);
    }

    @Test
    void 게시물_생성_테스트() throws Exception {
        mockMvc.perform(
                        post("/api/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                                .content(parameter)
                )
                .andExpect(status().isOk());
    }

}














