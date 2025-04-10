CREATE DATABASE HospitalSGH;

USE HospitalSGH;

CREATE TABLE usuarios (
	id int primary key auto_increment,
    nombre_usuario varchar(100) not null,
    contraseña varchar(100) not null
);

CREATE TABLE DOCTOR(
especialidad varchar(20) not null,
jornada varchar(20) not null,
id_doctor int primary key auto_increment,
nombre varchar(20) not null
);

CREATE TABLE PACIENTE(
edad int not null,
peso decimal not null,
estatura decimal not null,
id_paciente int primary key auto_increment,
nombre varchar(20)
);

CREATE TABLE tipos_cirugia(
	id_tipo int primary key auto_increment,
    tipo_cirugia varchar(100),
    especialidad varchar(20)
);

CREATE TABLE CIRUGIAS(
	id_cirugia int primary key auto_increment,
    fecha varchar(10) not null,
    hora varchar(10) not null,
    numQuirofano int not null,
    tipo_Cirugia varchar(100) not null,
    nombreDoctor varchar(50) not null,
    nombrePaciente varchar(50) not null,
    tiempo_duracion int not null
);

Insert into tipos_cirugia(tipo_cirugia, especialidad) 
VALUES
("Reemplazo de válvulas cardíacas","Cardíología"),
("Implante de marcapasos","Cardíología"),
("Trasplante de corazón","Cardíología"),
("Cirugía de cataratas","Oftalmología"),
("Cirugía refractiva","Oftalmología"),
("Cirugía de glaucoma","Oftalmología"),
("Extirpación de lunares o quistes","Dermatología"),
("Corrección de cicatrices","Dermatología"),
("Injertos de piel","Dermatología"),
("Colecistectomía","Gastroenterología"),
("Apendicectomía","Gastroenterología"),
("Herniorrafía","Gastroenterología");

insert into PACIENTE(edad, peso, estatura, nombre) 
VALUES
(25,87,190,"Emanuel"),
(35,70,160,"Melissa"),
(50,67,150,"Karla"),
(90,60,160,"Josefina"),
(25,87,190,"Juan Carlos");

insert into DOCTOR(especialidad, jornada, nombre) 
VALUES
("Cardiología","Jornada Diurna","Patricia"),
("Gastroenterología","Jornada Nocturna","Ernesto"),
("Oftalmología","Jornada Mixta","Federico"),
("Dermatología","Turnos Rotativos","Samuel");

INSERT INTO cirugias (fecha, hora, numQuirofano, tipo_Cirugia, nombreDoctor, nombrePaciente, tiempo_duracion)
VALUES 
("26/04/2025", "02:00 pm", 7, "Reemplazo de válvulas cardíacas", "Patricia","Melissa",2),
("31/07/2025", "12:00 pm", 12, "Extirpación de lunares o quistes", "Samuel","Josefina",1),
("29/10/2025", "07:00 am", 78, "Cirugía refractiva", "Federico","Emanuel",1);
