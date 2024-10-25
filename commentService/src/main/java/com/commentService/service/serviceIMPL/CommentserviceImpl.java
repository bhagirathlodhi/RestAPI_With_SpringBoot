package com.commentService.service.serviceIMPL;

import com.commentService.Entity.Comment;
import com.commentService.Repository.CommentRepository;
import com.commentService.service.CommentService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CommentserviceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentserviceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dt = LocalDate.now();
        comment.setDate(dt.format(myFormatObj));
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findById(Integer commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public List<Comment> loadAll(Integer postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
      System.out.println(comments.size()+ ": ::::::::::::::>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return comments;
    }
}
