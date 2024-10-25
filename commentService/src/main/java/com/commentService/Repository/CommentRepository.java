package com.commentService.Repository;

import com.commentService.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByPostId(Integer postId);




    @Query(value = "select * from comment where author = :author", nativeQuery = true)
    List<Comment> findByAuthor(@Param("author") String author);

}
