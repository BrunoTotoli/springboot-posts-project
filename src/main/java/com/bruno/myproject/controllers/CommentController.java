package com.bruno.myproject.controllers;


import com.bruno.myproject.entities.Comment;
import com.bruno.myproject.entities.User;
import com.bruno.myproject.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        return ResponseEntity.ok().body(commentService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(commentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        return new ResponseEntity<Comment>(commentService.insert(comment), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}/user")
    public ResponseEntity<User> postFindUser(@PathVariable Long id) {
        User user = commentService.findById(id).getUser();
        return ResponseEntity.ok().body(user);
    }


}
