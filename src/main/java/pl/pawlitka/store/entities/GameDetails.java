package pl.pawlitka.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game_details")
public class GameDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount_in_percentage")
    private Integer discountInPercentage;

    @Column(name = "reviews")
    private Integer reviews;

    @Column(name = "number_of_stars")
    private Integer numberOfStars;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "active")
    private boolean active;

    @OneToOne
    @JoinColumn(name = "platform_id", referencedColumnName = "id")
    private Platform platform;


    @ManyToMany
    @JoinTable(
            name = "games_detail_genre",
            joinColumns = @JoinColumn(name = "game_details_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id"))
    private Set<Genre> genres;
}
