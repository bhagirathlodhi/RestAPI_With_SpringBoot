package com.commentService.service;

import com.commentService.Entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment createComment(Comment comment);

    Optional<Comment> findById(Integer commentId);

    List<Comment> loadAll(Integer postId);
}
