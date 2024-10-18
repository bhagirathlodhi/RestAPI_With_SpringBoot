package com.posts.services;


import com.posts.Entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {


    Post create(Post post);

    Optional<Post> findById(Integer postId);

    List<Post> allPost();
}
