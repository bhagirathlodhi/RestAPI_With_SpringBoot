package com.commentService.service.serviceIMPL;

import com.commentService.Entity.Comment;
import com.commentService.Repository.CommentRepository;
import com.commentService.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentserviceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentserviceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
      return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findById(Integer commentId) {
        return commentRepository.findById(commentId);
    }
}
