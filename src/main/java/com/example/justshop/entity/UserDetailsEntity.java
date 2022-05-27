package com.example.justshop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users_details")
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
/*
    @OneToOne(cascade = CascadeType.REMOVE)
    private Bucket bucket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_")
    private List<OrderEntity> order;*/
}
