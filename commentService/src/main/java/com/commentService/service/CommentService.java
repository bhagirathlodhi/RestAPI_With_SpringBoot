package com.commentService.service;

import com.commentService.Entity.Comment;

import java.util.Optional;

public interface CommentService {
    Comment createComment(Comment comment);

    Optional<Comment> findById(Integer commentId);
}
