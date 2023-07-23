package com.rest.blog.myblogapp.service.impl;

import com.rest.blog.myblogapp.entity.Post;
import com.rest.blog.myblogapp.exception.ResourceNotFoundException;
import com.rest.blog.myblogapp.payload.PostDto;
import com.rest.blog.myblogapp.repository.PostRepository;
import com.rest.blog.myblogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PostDto> getPostList() {
        return postRepository
                .findAll()
                .stream()
                .map(Post::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostDetail(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        ).toDto();
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        Post findPost = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        return postRepository.save(findPost.updatePost(postDto)).toDto();
    }

}
