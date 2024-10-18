package com.posts.exception;
public class PostNotFoundException extends RuntimeException {


    public PostNotFoundException(Integer postId) {
        super("Post not found with ID: " + postId);
    }


}
