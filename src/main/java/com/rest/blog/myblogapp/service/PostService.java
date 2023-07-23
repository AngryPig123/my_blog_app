package com.rest.blog.myblogapp.service;

import com.rest.blog.myblogapp.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getPostList();

    PostDto getPostDetail(Long id);

    PostDto updatePost(Long id, PostDto postDto);

}
