-- banco.sql
CREATE DATABASE IF NOT EXISTS banco;
USE banco;

-- Tabla de administradores
CREATE TABLE administrador (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_completo VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(100) NOT NULL
);

-- Tabla de clientes
CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_completo VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(100) NOT NULL,
    sexo VARCHAR(20),
    profesion VARCHAR(100),
    direccion VARCHAR(200)
);

-- Tabla de cuentas de ahorro
CREATE TABLE cuenta_ahorro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero_cuenta VARCHAR(20) NOT NULL UNIQUE,
    saldo DECIMAL(10,2) NOT NULL,
    activa BOOLEAN DEFAULT TRUE,
    porcentaje_interes DECIMAL(5,2) NOT NULL,
    correo_cliente VARCHAR(100) NOT NULL,
    FOREIGN KEY (correo_cliente) REFERENCES cliente(correo_electronico)
);

-- Tabla de cuentas de débito
CREATE TABLE cuenta_debito (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero_cuenta VARCHAR(20) NOT NULL UNIQUE,
    saldo DECIMAL(10,2) NOT NULL,
    activa BOOLEAN DEFAULT TRUE,
    porcentaje_interes DECIMAL(5,2) NOT NULL,
    correo_cliente VARCHAR(100) NOT NULL,
    FOREIGN KEY (correo_cliente) REFERENCES cliente(correo_electronico)
);

-- Tabla de cuentas de crédito
CREATE TABLE cuenta_credito (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero_cuenta VARCHAR(20) NOT NULL UNIQUE,
    saldo DECIMAL(10,2) NOT NULL DEFAULT 0,
    activa BOOLEAN DEFAULT TRUE,
    limite_credito DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    correo_cliente VARCHAR(100) NOT NULL,
    FOREIGN KEY (correo_cliente) REFERENCES cliente(correo_electronico)
);