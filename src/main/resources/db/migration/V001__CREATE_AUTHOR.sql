CREATE TABLE author
(
    id         BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    about      VARCHAR(255) NOT NULL
) ENGINE = InnoDB