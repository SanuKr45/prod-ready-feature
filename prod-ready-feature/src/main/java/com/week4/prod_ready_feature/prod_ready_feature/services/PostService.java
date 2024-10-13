package com.week4.prod_ready_feature.prod_ready_feature.services;

import com.week4.prod_ready_feature.prod_ready_feature.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPost();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postsId);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
