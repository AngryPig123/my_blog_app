package com.rest.blog.myblogapp.entity.repository;

import com.rest.blog.myblogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class Repository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected PostRepository postRepository;

}
