package com.posts.services.imp;
import com.posts.Entity.Post;
import com.posts.repository.PostRepo;
import com.posts.services.CommentClient;
import com.posts.services.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceIMPL implements PostService {

    private PostRepo postRepo;
//    private CommentClient commentClient;

    public ServiceIMPL(PostRepo postRepo) {
        this.postRepo = postRepo;
//        this.commentClient = commentClient;
    }

    @Override
    public Post create(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Optional<Post> findById(Integer postId) {
        return postRepo.findById(postId);
    }

//    @Override
//    public List<Post> allPost() {
//        List<Post> postComment =  postRepo.findAll();
//
//        List<Post> newPostComment =  postComment.stream().map(post -> {
//            post.setComments(commentClient.getCommentOfPost(post.getPost_id()));
//            return post;
//        }).collect(Collectors.toList());
//        return newPostComment;
//    }

    @Override
    public List<Post> allPost() {
        return postRepo.findAll();
    }




}
