package com.github.pawlitka.ecommerceapp.game.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name="id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "developer_name", nullable = false, unique = true)
    private String developerName;

}
