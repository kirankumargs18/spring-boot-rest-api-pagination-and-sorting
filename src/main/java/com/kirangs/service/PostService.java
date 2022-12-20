package com.kirangs.service;

import com.kirangs.entity.Post;
import com.kirangs.payload.ListApiResponse;

public interface PostService {

	Post createPost(Post post);

	ListApiResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

}
