use master if exists (SELECT * FROM SYS.databases WHERE name = 'bd_sgm')
DROP DATABASE bd_sgm
GO
CREATE DATABASE bd_sgm
GO
USE bd_sgm
GO
CREATE TABLE Usuario (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome NVARCHAR(255) NOT NULL,
    tipoUsuario VARCHAR(14) NULL,
    email NVARCHAR(45) NOT NULL,
    senha NVARCHAR(255) NOT NULL
);
GO
INSERT INTO Usuario (nome,tipoUsuario,email,senha) 
     VALUES ('gabriel','Aluno','sa@gmail.com','12345678');
SELECT * FROM Usuario
SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Usuario';