package com.akhilesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhilesh.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
