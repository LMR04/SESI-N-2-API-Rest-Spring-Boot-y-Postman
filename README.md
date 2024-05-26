1. En el archivo "Asesoria" estamos utilizando la JDBC
2. En cambio en el archivo "AsesoriaJPA" utilizamos JPA

Aqui esta el script para crear la base de datos que utilizamos

-- Crear la base de datos
CREATE DATABASE Asesoria;
GO

-- Usar la base de datos
USE Asesoria;
GO

-- Crear la tabla Estudiante
CREATE TABLE Estudiante (
    id INT PRIMARY KEY IDENTITY(1,1), -- La columna id es autoincremental
    name VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(50),
    semester INT
);
GO

-- Insertar los registros en la tabla Estudiantes
INSERT INTO Estudiante (name, lastname, email, semester) VALUES
('Jose', 'Venegas', 'josevenegas@uni.pe', 5),
('Miguel', 'Rubio', 'luisrubio@uni.pe', 4),
('Yael', 'Varillas', 'yaelvarillas@uni.pe', 4),
('Caleb', 'Romero', 'calebromero@uni.pe', 3),
('Alfredo', 'Alvarado', 'alfredoalvarado@uni.pe', 2);
GO
