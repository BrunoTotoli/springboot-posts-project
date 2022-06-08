package com.bruno.myproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Instant date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_comment_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_comments_id")
    private Post post;

    public String getNameUser() {
        return user.getName() + "  Id:" + user.getId();
    }
}
