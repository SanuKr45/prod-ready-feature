package com.week4.prod_ready_feature.prod_ready_feature.services;

import com.week4.prod_ready_feature.prod_ready_feature.dto.PostDTO;
import com.week4.prod_ready_feature.prod_ready_feature.entities.PostEntity;
import com.week4.prod_ready_feature.prod_ready_feature.exceptions.ResourceNotFound;
import com.week4.prod_ready_feature.prod_ready_feature.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PostServiceImp implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<PostDTO> getAllPost() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(
                                postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);

    }

    @Override
    public PostDTO getPostById(Long postsId) {
        PostEntity postEntity = postRepository.findById(postsId)
                .orElseThrow(()-> new ResourceNotFound("Recourse not found with the given id"+postsId));
        return modelMapper.map(postEntity, PostDTO.class);

    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
       PostEntity olderPost = postRepository.findById(postId)
               .orElseThrow(()->new ResourceNotFound("Recourse not found with the given id"+postId));
       inputPost.setId(postId);
       modelMapper.map(inputPost, olderPost);
       PostEntity savedPostEntity = postRepository.save(olderPost);
       return modelMapper.map(savedPostEntity, PostDTO.class);
    }
}
