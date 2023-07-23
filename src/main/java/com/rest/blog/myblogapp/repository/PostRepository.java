package com.rest.blog.myblogapp.repository;

import com.rest.blog.myblogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
