CREATE TABLE IF NOT EXISTS exercise (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    series INT NOT NULL,
    repetitions_or_seconds INT NOT NULL,
    weight DOUBLE NOT NULL
);