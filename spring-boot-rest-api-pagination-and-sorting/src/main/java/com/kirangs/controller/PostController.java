package com.kirangs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kirangs.entity.Post;
import com.kirangs.payload.ListApiResponse;
import com.kirangs.service.PostService;

@RestController
@RequestMapping("/api/v1/post-service")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<ListApiResponse> fetchAllPosts(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize, @RequestParam(defaultValue = "title") String sortBy,
			@RequestParam(defaultValue = "ASC") String sortDir) {

		return new ResponseEntity<>(postService.getAllPosts(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Post> savePost(@RequestBody Post post) {

		return new ResponseEntity<Post>(postService.createPost(post), HttpStatus.CREATED);
	}

}
