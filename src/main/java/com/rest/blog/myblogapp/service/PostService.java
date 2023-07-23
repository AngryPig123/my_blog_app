package com.rest.blog.myblogapp.service;

import com.rest.blog.myblogapp.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
