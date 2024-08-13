package com.mycompany.projetoe;

CREATE DATABASE BancoDB;

USE BancoDB;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    numero_conta VARCHAR(20) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    saldo DECIMAL(10, 2) DEFAULT 0.00
);

CREATE TABLE Transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_transacao ENUM('DEPOSITO', 'SAQUE') NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);