ALTER SESSION SET CONTAINER = FREEPDB1;

CREATE USER ECOMMERCE_DB IDENTIFIED BY YourStrongPassword123;
GRANT CONNECT, RESOURCE, DBA TO ECOMMERCE_DB;
ALTER USER ECOMMERCE_DB QUOTA UNLIMITED ON USERS;

-- 3. Switch to that user context for the rest of the script
ALTER SESSION SET CURRENT_SCHEMA = ECOMMERCE_DB;

CREATE TABLESPACE blob_storage_ts
    DATAFILE 'blob_storage_01.dbf' SIZE 100M AUTOEXTEND ON;

CREATE TABLE genre (
    id INT GENERATED ALWAYS AS IDENTITY ,
    name VARCHAR2(100),
    developer_name VARCHAR2(100) NOT NULL UNIQUE,
    CONSTRAINT pk_genre PRIMARY KEY (id)
);

CREATE TABLE platform (
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR2(100),
    developer_name VARCHAR2(100) NOT NULL UNIQUE,
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
    price NUMBER(10, 2),
    main_image BLOB,
    reviews_count INT DEFAULT 0,
    discount_in_percentage NUMBER(1,2) DEFAULT 0,
    rate INT,
    description VARCHAR2(4000),
    CONSTRAINT pk_game PRIMARY KEY (id),
    CONSTRAINT check_price CHECK ( price >= 0 ),
    CONSTRAINT check_reviews_count CHECK ( reviews_count >= 0 ),
    CONSTRAINT check_discount_in_percentage CHECK (discount_in_percentage BETWEEN 0 AND 1),
    CONSTRAINT check_rate CHECK (rate BETWEEN 0 AND 5 )
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
    CONSTRAINT fk_gg_game_id FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
    CONSTRAINT fk_gg_genre_id FOREIGN KEY (genre_id) REFERENCES genre(id) ON DELETE CASCADE
);

CREATE TABLE game_platform (
    game_id INT,
    platform_id INT,
    CONSTRAINT pk_game_platform PRIMARY KEY (game_id, platform_id),
    CONSTRAINT fk_gp_game_id FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
    CONSTRAINT fk_gp_platform_id FOREIGN KEY (platform_id) REFERENCES platform(id) ON DELETE CASCADE
);

COMMIT;