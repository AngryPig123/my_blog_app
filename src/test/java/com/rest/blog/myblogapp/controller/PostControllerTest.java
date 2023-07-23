package com.rest.blog.myblogapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.blog.myblogapp.payload.PostDto;
import com.rest.blog.myblogapp.service.PostService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostControllerTest extends ControllerTestBase {

    private static PostDto postDto;
    private static String parameter;

    @Autowired
    private PostService postService;

    @BeforeAll
    static void beforeEach() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        postDto = PostDto.builder()
                .title("테스트 타이틀")
                .description("테스트 디스크립션")
                .content("테스트 콘텐츠")
                .build();
        parameter = objectMapper.writeValueAsString(postDto);
    }

    @Test
    @Order(1)
    void 게시물_생성_테스트() throws Exception {
        mockMvc.perform(
                        post("/api/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                                .content(parameter)
                )
                .andExpect(status().is(201));
    }

    @Test
    @Order(2)
    void 게시물_리스트_조회_테스트() throws Exception {
        mockMvc.perform(
                        get("/api/post")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    @Order(3)
    void 게시물_상세_조회_성공_테스트() throws Exception {
        mockMvc.perform(
                        get("/api/post/{id}", 1L)
                )
                .andExpect(status().isOk());
    }

    @Test
    void 게시물_상세_조회_실패_테스트() throws Exception {
        mockMvc.perform(
                        get("/api/post/{id}", (Long.MAX_VALUE - 1))
                )
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.timeStamp").exists())
                .andExpect(jsonPath("$.details").exists())
                .andDo(print());
    }

}















