package com.github.pawlitka.ecommerceapp.game.repository;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
