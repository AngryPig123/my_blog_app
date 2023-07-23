package com.rest.blog.myblogapp.service.impl;

import com.rest.blog.myblogapp.entity.Post;
import com.rest.blog.myblogapp.payload.PostDto;
import com.rest.blog.myblogapp.repository.PostRepository;
import com.rest.blog.myblogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = postDto.toEntity();
        Post save = postRepository.save(post);
        return save.toDto();
    }

}
