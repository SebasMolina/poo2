-- alter table proveedor add column telefono varchar;
/*
-- 
*/



-- inserto una persona.
insert into persona (nombre, apellido, mail, contrasenia, tipopersona) values (
	'Gonzalo', 'Vicente', 'gonzalovicente@gmail.com', 'gvicente', 2);
-- select de persona
select * from persona;
-- inserto un proveedor con la FK de una persona existente.
insert into proveedor values (
	5, 'Mostaza', '08:30' , '21:00', 'Buenos Aires');
-- select de proveedor
select * from proveedor;
-- inserto una direccion con la FK de una persona existente
insert into direccion values (
	5, 'San Juan', '5680', 1300, '1', 'c');
-- select de direccion
select * from direccion;
-- consulta para traer proveedores
select (proveedorid, razonsocial, telefono, ciudad, calle, numero, piso, dpto)
	from proveedor inner join direccion on
	proveedorid=personaid;
update proveedor SET telefono='3764555657' WHERE razonsocial='Ketchup';
SELECT * FROM persona INNER JOIN direccion ON persona.personaid=direccion.personaid 
	LEFT JOIN proveedor ON direccion.personaid=proveedorid 
	WHERE tipopersona=2
SELECT * FROM proveedor
SELECT * FROM persona
select * from direccion;
DELETE FROM proveedor WHERE proveedorid=31;

DELETE FROM direccion WHERE personaid=30;
DELETE FROM persona WHERE personaid=1;
/*
2;"Antonio";"Cabrera";"antoniocabrera@gmail.com";"antonio1234";2;2;"Santiago del estero";"1380";"3300";"1";"-";2;"3765414243";"Burger Quenn";"19:00:00";"01:00:00";"Posadas"

*/
-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;
/*
-- 
*/

--
SELECT nombre, apellido, telefono, nombreusuario FROM persona
	INNER JOIN usuario ON personaid=usuarioid
	WHERE nombreusuario= 'pedritoAlfonsinho';
-- pedritoalfonsinho, pablogomezinho
-- select de usuario
select * from usuario;
select * from persona;

SELECT usuarioid, nombre, apellido, mail, contrasenia, nombreusuario, telefono
	from persona inner join usuario on personaid=usuarioid;

SELECT usuarioid, nombre, apellido, mail, contrasenia, nombreusuario, telefono FROM persona
	INNER JOIN usuario ON personaid=usuarioid;

SELECT * FROM persona INNER JOIN direccion ON persona.personaid=direccion.personaid 
	LEFT JOIN usuario ON persona.personaid=usuarioid 
	WHERE tipopersona=1;

/*
-- 
*/