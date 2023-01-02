package com.kirangs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kirangs.entity.Post;
import com.kirangs.payload.ListApiResponse;
import com.kirangs.repository.PostRepository;
import com.kirangs.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post createPost(Post post) {

		return postRepository.save(post);
	}

	@Override
	public ListApiResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

//		Sort sort=Sort.by("id").descending();
//
//		return postRepository.findAll(sort);

//		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() : 
//			Sort.by(sortBy).descending();
//		
//		return postRepository.findAll(sort);

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable Instance

		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Post> posts = postRepository.findAll(pageable);

		List<Post> allPosts = posts.getContent();
		
		ListApiResponse apiResponse=new ListApiResponse();
		
		apiResponse.setPosts(allPosts);
		apiResponse.setPageNo(posts.getNumber());
		apiResponse.setPageSize(posts.getSize());
		apiResponse.setTotalElements(posts.getTotalElements());
		apiResponse.setTotalPages(posts.getTotalPages());
		apiResponse.setLastPage(posts.isLast());

		return apiResponse;
	}

}
