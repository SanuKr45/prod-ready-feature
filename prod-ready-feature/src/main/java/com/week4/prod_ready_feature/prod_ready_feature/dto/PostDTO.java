package com.week4.prod_ready_feature.prod_ready_feature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {

    private Long id;

    private String title;

    private String description;

}
