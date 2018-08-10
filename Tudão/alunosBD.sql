DROP DATABASE IF EXISTS alunos_notas;
CREATE DATABASE IF NOT EXISTS alunos_notas;
USE alunos_notas;

CREATE TABLE alunos(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	codigoMatricula VARCHAR(50),
	nota1 FLOAT UNSIGNED,
	nota2 FLOAT UNSIGNED,
	nota3 FLOAT UNSIGNED,
	frequencia TINYINT UNSIGNED
); 

INSERT INTO alunos(nome, codigoMatricula, nota1, nota2, nota3, frequencia) VALUES
('Mia Khalifa','12312',8.9,6.7,6.8,67),
('Sasha Grey','145125',9.3,6.7,7.5,98),
('Jesica Stoya','15124',6.6,6.7,8.3,23),
('Alexis Texas','1623432',2.6,6.7,4.3,74);

SELECT * FROM alunos;