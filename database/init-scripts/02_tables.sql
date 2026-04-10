CREATE TABLESPACE blob_storage_ts
    DATAFILE 'blob_storage_01.dbf' SIZE 100M AUTOEXTEND ON;

CREATE TABLE genre (
    id INT GENERATED ALWAYS AS IDENTITY ,
    name VARCHAR(100),
    developer_name VARCHAR(100) NOT NULL UNIQUE,

    CONSTRAINT pk_genre PRIMARY KEY (id)
);

CREATE TABLE platform (
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100),
    developer_name VARCHAR(100) NOT NULL UNIQUE,
    logo_picture BLOB,

    CONSTRAINT pk_platform PRIMARY KEY (id)
)
LOB (logo_picture) STORE AS SECUREFILE (
   TABLESPACE blob_storage_ts
   COMPRESS MEDIUM
   DEDUPLICATE
   CACHE
);

CREATE TABLE game (
    id INT GENERATED ALWAYS AS IDENTITY ,
    title VARCHAR2(255),
    price DECIMAL(10, 2),
    main_image BLOB,
    reviews_count INT DEFAULT 0,
    discount_in_percentage DECIMAL(1,2) DEFAULT 0,
    rate INT,
    description VARCHAR2(4000),

    CONSTRAINT pk_game PRIMARY KEY (id),
    CONSTRAINT check_price CHECK ( price >= 0 ),
    CONSTRAINT check_reviews_count CHECK ( reviews_count >= 0 ),
    CONSTRAINT check_discount_in_percentage CHECK ( 1 >= discount_in_percentage >= 0 ),
    CONSTRAINT check_rate CHECK (5 >= rate >= 0 )
)
LOB (main_image) STORE AS SECUREFILE (
   TABLESPACE blob_storage_ts
   COMPRESS MEDIUM
   DEDUPLICATE
   CACHE
);

CREATE TABLE game_genre (
    game_id INT,
    genre_id INT,
    CONSTRAINT pk_game_genre PRIMARY KEY (game_id, genre_id),
    CONSTRAINT fk_game_id FOREIGN KEY (game_id) REFERENCES Game(id) ON DELETE CASCADE,
    CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES Genre(id) ON DELETE CASCADE
);

CREATE TABLE game_platform (
    game_id INT,
    platform_id INT,
    CONSTRAINT pk_game_platform PRIMARY KEY (game_id, platform_id),
    CONSTRAINT fk_game_id FOREIGN KEY (game_id) REFERENCES Game(id) ON DELETE CASCADE,
    CONSTRAINT fk_platform_id FOREIGN KEY (platform_id) REFERENCES Platform(id) ON DELETE CASCADE
);
