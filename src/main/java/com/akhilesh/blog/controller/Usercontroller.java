package com.akhilesh.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhilesh.blog.payloads.ApiResponse;
import com.akhilesh.blog.payloads.UserDto;
import com.akhilesh.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class Usercontroller {
	@Autowired
	private UserService userSerice;
	
	//POST -create usery
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userSerice.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	//PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updatUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
		UserDto updateUser = this.userSerice.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);
	}
	
	//DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userSerice.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	//GET - user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userSerice.getAllUsers());
	}
	
	
	//GET - user get
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId){
			return ResponseEntity.ok(this.userSerice.getUserById(userId));
		}

}
