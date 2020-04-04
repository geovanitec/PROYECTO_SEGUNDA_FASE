create database NUEVOS_USUARIOS;
use NUEVOS_USUARIOS;

create table nuevo_usuario
(

Usuario varchar (60) primary key,
Pass varchar(60) not null,
Confirmar_Pass varchar (60) not null

)engine=InnoDB Default charset = Latin1 ;



