package com.github.pawlitka.ecommerceapp.game.repository;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
}
