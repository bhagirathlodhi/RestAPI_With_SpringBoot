package com.posts.controllers;

import com.posts.Entity.Post;
import com.posts.exception.PostNotFoundException;
import com.posts.repository.PostRepo;
import com.posts.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostsController {

    private final PostService postService;
    private final PostRepo postRepo;

    private PostsController(PostService postService, PostRepo postRepo) {
        this.postService = postService;
        this.postRepo = postRepo;
    }

    @PostMapping
    public Post create(@RequestBody Post post){
        return  postService.create(post);

    }

    @GetMapping("/{postId}")
    public Optional<Post> getPost(@PathVariable Integer postId) throws PostNotFoundException {
        return Optional.of(postService.findById(postId)  .orElseThrow(() -> new PostNotFoundException(postId)));
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.allPost();
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Integer postId, @RequestBody Post post){
        return postRepo.findById(postId).map(newData -> {
            newData.setPost_title(post.getPost_title());
            newData.setPost_content(post.getPost_content());
            return postRepo.save(newData);
        }).orElseGet(() -> {
            return null;
        });
//
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId){
        Optional<Post> post = postRepo.findById(postId);
        if(post.isPresent()){
            postRepo.delete(post.get());
            return ResponseEntity.ok("Post deleted successfully.");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found.");
    }


}
