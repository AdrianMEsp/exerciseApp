CREATE TABLE IF NOT EXISTS exercise (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    series VARCHAR(255) NOT NULL,
    repetitions_or_minutes INT NOT NULL,
    weight DOUBLE NOT NULL,
    description VARCHAR(255) NOT NULL
);