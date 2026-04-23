package com.github.pawlitka.ecommerceapp.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatformDto {
    private Long id;
    private String name;
    private String developerName;
    private byte[] logoPicture;
}
