package com.bruno.myproject.controllers;

import com.bruno.myproject.entities.Post;
import com.bruno.myproject.entities.User;
import com.bruno.myproject.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok().body(postService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.insert(post), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}/user")
    public ResponseEntity<User> postFindUser(@PathVariable Long id) {
        User user = postService.findById(id).getUser();
        return ResponseEntity.ok().body(user);
    }
}
