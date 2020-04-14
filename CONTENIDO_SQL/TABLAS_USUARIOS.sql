create database NUEVOS_USUARIOS;
use NUEVOS_USUARIOS;

create table nuevo_usuario
(
Id_Usuario int auto_increment ,
Usuario varchar (60) primary key,

Pass varchar(60) not null,
Id_Usuario int primary key
#Confirmar_Pass varchar (60) not null

)engine=InnoDB Default charset = Latin1 ;



