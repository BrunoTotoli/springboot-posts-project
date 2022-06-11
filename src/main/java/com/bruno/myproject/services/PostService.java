package com.bruno.myproject.services;


import com.bruno.myproject.entities.Post;
import com.bruno.myproject.entities.User;
import com.bruno.myproject.entities.exceptions.ResourceNotFoundException;
import com.bruno.myproject.repositories.PostRepository;
import com.bruno.myproject.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    public Post insert(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ResourceNotFoundException("Post Id: " + id + " Not Found"));
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
