package com.week4.prod_ready_feature.prod_ready_feature.repositories;

import com.week4.prod_ready_feature.prod_ready_feature.dto.PostDTO;
import com.week4.prod_ready_feature.prod_ready_feature.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
