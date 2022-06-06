package com.bruno.myproject.repositories;

import com.bruno.myproject.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
