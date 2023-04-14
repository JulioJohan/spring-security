insert alumnos(numero_control, nombre, email, fecha_registro) values('1220100121','Johan','juliojohan10@gmail.com','2023/03/23')

insert alumnos(numero_control, nombre, email, fecha_registro) values('1220100122','Mari','mari@gmail.com','2023/03/23')

insert alumnos(numero_control, nombre, email, fecha_registro) values('1220100123','Denis','denis@gmail.com','2023/03/23')

insert alumnos(numero_control, nombre, email, fecha_registro) values('1220100124','Itzel','itzel@gmail.com','2023/03/23')

insert alumnos(numero_control, nombre, email, fecha_registro) values('1220100125','Fati','fati@gmail.com','2023/03/23')

insert Alumnos(numero_Control, nombre, email, fecha_Registro) values('1220100234', 'Sergio', 'sergio@gmail.com', '2023/03/16');
insert Alumnos(numero_Control, nombre, email, fecha_Registro) values('1218100987', 'Humberto', 'humberto@gmail.com', '2023/01/22');

INSERT INTO roles(`id`,`nombre`) VALUES ( 1,'write'); 
INSERT INTO roles(`id`,`nombre`) VALUES ( 2,'read'); 

INSERT INTO usuarios(`id`,`apellido`,`email`,`enabled`,`nombre`,`password`,`username`) VALUES ( 1,'Guerrero','aguerrero@gmail.com',1,'Alejandro','$2a$10$JNlnnxCyHuxkWg/bUH4kvuyWsp5Tf0LflZJ4xTLgM8KAfPG6Bx/Ma','aguerrero'); 
INSERT INTO usuarios(`id`,`apellido`,`email`,`enabled`,`nombre`,`password`,`username`) VALUES ( 2,'barrientos','humberto@gmail.com',1,'humberto','$2a$10$8QsK1M6EAsE7lQJGrD6BfePv3FLMwvEsYj4Jldm/kks5owZtQYTJe','hbarrientos'); 

INSERT INTO usuarios_roles(`usuario_id`,`role_id`) VALUES ( '1','1'); 
INSERT INTO usuarios_roles(`usuario_id`,`role_id`) VALUES ( '2','2'); 