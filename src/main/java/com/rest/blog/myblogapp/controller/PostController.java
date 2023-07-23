package com.rest.blog.myblogapp.controller;


import com.rest.blog.myblogapp.payload.PostDto;
import com.rest.blog.myblogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPostList() {
        return new ResponseEntity<>(postService.getPostList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPostDetail(id), HttpStatus.OK);
    }

}
