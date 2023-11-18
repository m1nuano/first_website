package com.demo.m1nuano.website.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "t_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @Column(name = "imageURL")
    private String imageURL;
}
