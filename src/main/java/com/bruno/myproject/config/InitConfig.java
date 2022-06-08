package com.bruno.myproject.config;

import com.bruno.myproject.entities.Comment;
import com.bruno.myproject.entities.Post;
import com.bruno.myproject.entities.User;
import com.bruno.myproject.repositories.CommentRepository;
import com.bruno.myproject.repositories.PostRepository;
import com.bruno.myproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;


@Configuration
public class InitConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {


        User user = new User(null, "Bruno", "Bruno@gmail.com", null);
        User user2 = new User(null, "Bruno", "Bruno@gmail.com", null);
        Post post1 = new Post(null, Instant.now(), "Um Post Foda", "Escrevendo no post", null, null);
        Post post2 = new Post(null, Instant.now(), "Um Post Fodelancio", "Escrevendo no post incrivelmente", null, null);
        Comment comment = new Comment(null, "Comentario bem incrivel", Instant.now(), user, post1);
        Comment comment2 = new Comment(null, "Comentario bem incrivel do 2", Instant.now(), user2, post1);

        postRepository.saveAll(Arrays.asList(post1, post2));
        userRepository.saveAll(Arrays.asList(user, user2));
        commentRepository.saveAll(Arrays.asList(comment, comment2));


        user.setPosts(Arrays.asList(post1, post2));

        userRepository.save(user);

        post1.setUser(user);
        post2.setUser(user);

        postRepository.saveAll(Arrays.asList(post1, post2));
        post1.setComments(Arrays.asList());
        post2.setComments(Arrays.asList());

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
