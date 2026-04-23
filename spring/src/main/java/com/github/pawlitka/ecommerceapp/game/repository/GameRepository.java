package com.github.pawlitka.ecommerceapp.game.repository;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    @Query("SELECT g FROM Game g LEFT JOIN FETCH g.genres")
    List<Game> findAllWithGenres();
}
