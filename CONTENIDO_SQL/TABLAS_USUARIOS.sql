create database NUEVOS_USUARIOS;
use NUEVOS_USUARIOS;

create table nuevo_usuario
(
Id_Usuario int auto_increment primary key,
Usuario varchar (60)not null,

Pass varchar(60) not null


)engine=InnoDB Default charset = Latin1 ;


create table usuario_administrador
(
Usuario varchar (60) primary key,
pass varchar (60) not null

)engine=InnoDB Default charset = Latin1 ;
