
DROP table IF EXISTS empleados;

create table empleados (
	id int auto_increment primary key,
	nombre varchar(100),
	trabajo ENUM('ProgramadorSQL', 'ProgramadorJava', 'ProgramadorJS', 'ProgramadorC#', 'ProgramadorPHP') not null,
	salario int
);

INSERT INTO empleados (nombre, trabajo, salario) VALUES
('Veronika', 'ProgramadorSQL', 2500),
('Isidre', 'ProgramadorJava', 3000),
('Adria', 'ProgramadorJS', 3500),
('Marc', 'ProgramadorC#', 2500),
('Eloi', 'ProgramadorPHP', 3500);

