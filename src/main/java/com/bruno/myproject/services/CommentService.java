package com.bruno.myproject.services;

import com.bruno.myproject.entities.Comment;
import com.bruno.myproject.entities.exceptions.ResourceNotFoundException;
import com.bruno.myproject.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentService {
    private CommentRepository commentRepository;


    public Comment insert(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(Long id) {
        Optional<Comment> user = commentRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("Comment Id: " + id + " Not Found"));
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }


}
