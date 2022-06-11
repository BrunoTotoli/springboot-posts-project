package com.bruno.myproject.services;


import com.bruno.myproject.entities.Post;
import com.bruno.myproject.services.exceptions.DatabaseException;
import com.bruno.myproject.services.exceptions.ResourceNotFoundException;
import com.bruno.myproject.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Post Id: " + id + " Not Found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity constraint violation");
        }
    }
}
