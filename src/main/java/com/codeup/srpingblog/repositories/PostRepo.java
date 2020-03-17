package com.codeup.srpingblog.repositories;

import com.codeup.srpingblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository <Post, Long> {

    Post findPostByTitle(String title);
    Post findById(long id);

}
