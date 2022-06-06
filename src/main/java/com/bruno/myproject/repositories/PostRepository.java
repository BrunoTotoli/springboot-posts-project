package com.bruno.myproject.repositories;

import com.bruno.myproject.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
