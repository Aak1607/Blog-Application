package com.akhilesh.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhilesh.blog.entities.Category;
import com.akhilesh.blog.entities.Post;
import com.akhilesh.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);

	List<Post> findByTitleContaining(String keyword);

	

	
	

}
