package com.posts.services;

import com.posts.Entity.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8082", value = "Comment-Client")
public interface CommentClient {
    @GetMapping("/post/comment/{postId}")
    List<Comment> getCommentOfPost(@PathVariable Integer postId);
}
