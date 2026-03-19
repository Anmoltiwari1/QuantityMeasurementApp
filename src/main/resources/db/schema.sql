CREATE TABLE quantity_measurement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    measurement_value DOUBLE,
    unit VARCHAR(50),
    operation VARCHAR(50),
    created_at TIMESTAMP
);