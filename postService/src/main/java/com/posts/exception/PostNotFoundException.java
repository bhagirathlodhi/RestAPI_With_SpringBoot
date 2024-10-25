package com.posts.exception;
public class PostNotFoundException extends RuntimeException {


    public PostNotFoundException(String postId) {
        super("Post not found with ID: " + postId);
    }


}
