package com.commentService.controller;

import com.commentService.Entity.Comment;
import com.commentService.respo.Response;
import com.commentService.service.CommentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post/comment")
public class CommentController {

    private CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping
    public Response createComment(@RequestBody Comment comment) {
        Comment com = commentService.createComment(comment);

        Response response = new Response();
        if (com != null) {
            response.setStatus(200);
            response.setMessage("Success.");
            response.setData(com);
        } else {
            response.setStatus(400);
            response.setMessage("Failed to create comment.");
        }
        return response;
    }

//    @GetMapping("/{commentId}")
//    public Optional<Comment> getComment(@PathVariable Integer commentId) {
//        return commentService.findById(commentId);
//    }

    // Fetch all the comment

    @GetMapping("/{postId}")
    public List<Comment> getComments(@PathVariable Integer postId) {
        System.out.println("Hello from coment Controller>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return commentService.loadAll(postId);
    }


}
