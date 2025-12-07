-- Crear la base de datos
CREATE DATABASE formas_db;
USE formas_db;

-- Tabla para formas
CREATE TABLE formas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL,
    AREA DOUBLE NOT NULL,
    perimetro DOUBLE NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla para cuerpos
CREATE TABLE cuerpos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL,
    volumen DOUBLE NOT NULL,
    area_superficie DOUBLE NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de relación entre figuras y cuerpos
CREATE TABLE figuras_cuerpo (
    id_cuerpo INT,
    id_figura INT,
    FOREIGN KEY (id_cuerpo) REFERENCES cuerpos(id),
    FOREIGN KEY (id_figura) REFERENCES formas(id)
);

CREATE TABLE Forma (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50),
    color VARCHAR(50)
);

CREATE TABLE Cuerpo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50),
    volumen DOUBLE
);
-- Crear índices para mejorar el rendimiento
CREATE INDEX idx_tipo_forma ON formas(tipo);
CREATE INDEX idx_tipo_cuerpo ON cuerpos(tipo);

-- Vista para estadísticas de formas
CREATE VIEW estadisticas_formas AS
SELECT 
    tipo,
    COUNT(*) AS cantidad,
    AVG(AREA) AS promedio_area,
    AVG(perimetro) AS promedio_perimetro
FROM formas
GROUP BY tipo;

-- Vista para estadísticas de cuerpos
CREATE VIEW estadisticas_cuerpos AS
SELECT 
    tipo,
    COUNT(*) AS cantidad,
    AVG(volumen) AS promedio_volumen,
    AVG(area_superficie) AS promedio_area
FROM cuerpos
GROUP BY tipo;

-- Procedimiento almacenado para insertar forma
DELIMITER //
CREATE PROCEDURE insertar_forma(
    IN p_tipo VARCHAR(50),
    IN p_area DOUBLE,
    IN p_perimetro DOUBLE
)
BEGIN
    INSERT INTO formas (tipo, AREA, perimetro)
    VALUES (p_tipo, p_area, p_perimetro);
END //
DELIMITER ;

-- Procedimiento almacenado para insertar cuerpo
DELIMITER //
CREATE PROCEDURE insertar_cuerpo(
    IN p_tipo VARCHAR(50),
    IN p_volumen DOUBLE,
    IN p_area_superficie DOUBLE
)
BEGIN
    INSERT INTO cuerpos (tipo, volumen, area_superficie)
    VALUES (p_tipo, p_volumen, p_area_superficie);
END //
DELIMITER ;

-- Procedimiento para obtener estadísticas generales
DELIMITER //
CREATE PROCEDURE obtener_estadisticas()
BEGIN
    SELECT 'Formas' AS tipo,
           COUNT(*) AS total,
           SUM(AREA) AS area_total,
           SUM(perimetro) AS perimetro_total
    FROM formas
    UNION ALL
    SELECT 'Cuerpos',
           COUNT(*),
           SUM(area_superficie),
           SUM(volumen)
    FROM cuerpos;
END //
DELIMITER ;