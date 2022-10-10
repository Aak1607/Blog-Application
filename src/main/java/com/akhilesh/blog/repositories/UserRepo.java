package com.akhilesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.akhilesh.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
