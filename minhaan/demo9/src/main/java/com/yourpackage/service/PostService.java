package com.yourpackage.service;

import com.yourpackage.entity.Post;
import com.yourpackage.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post getPostById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public void deletePost(Integer id) {
        repository.deleteById(id);
    }
}
