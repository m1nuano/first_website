package com.demo.m1nuano.website.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "t_authority")
public class Authority {

    @Id
    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
}