-- drop database nomina_salario;
create database NOMINA_SALARIO;
use NOMINA_SALARIO;


-- drop table usuarios;
create table USUARIOS(
IdUsuario int primary key auto_increment,
NombreUsuario varchar (30) not null,
Pass varchar(12) not null
)Engine = InnoDB Default charset = Latin1;

#select * from usuarios;
#drop table DEPARTAMENTO;
create table usuario_administrador
(
Id_Admin int primary key auto_increment,
Usuario varchar (60) not null,
pass varchar (60) not null


)engine=InnoDB Default charset = Latin1 ;
#select *  from usuario_administrador;
insert into usuario_administrador values (1,"geova","123");

create table DEPARTAMENTO
(
IdDepartamento int primary key auto_increment,
NombreDepartamento varchar (30) not null
)Engine = InnoDB Default charset = Latin1 ;
#select * from DEPARTAMENTO;

-- drop table puesto;
create table PUESTO
(
IdPuesto int primary key,
NombrePuesto varchar (30) not null,
CodigoDepartamento int,
foreign key(CodigoDepartamento) references DEPARTAMENTO (IdDepartamento)
)Engine = InnoDB Default charset = Latin1 ;





#drop table DATOS_EMPLEADO;
create table DATOS_EMPLEADO
(
Id_Empleado int primary key,
CodigoPuesto int not null,
CodigoDepartamento int not null,
NombreEmpleado varchar (20) not null,
ApellidoEmpleado varchar (20) not null,
EdadEmpleado int (5) not null,
EstadoEmpleado varchar(20) not null,
foreign key(CodigoPuesto) references puesto (IdPuesto),
foreign key(CodigoDepartamento) references departamento (IdDepartamento)

)Engine = InnoDB Default charset = Latin1 ;

use NOMINA_SALARIO;
-- drop table excepciones;
create table EXCEPCIONES (
	IdExcepcion int auto_increment ,
    NombreConcepto varchar(40),
    CodigoEmpleado int,
    primary key(IdExcepcion,NombreConcepto,CodigoEmpleado),
	foreign key(CodigoEmpleado) references DATOS_EMPLEADO(Id_Empleado)
)Engine = InnoDB Default charset = Latin1 ;
#select * from excepciones;

 use NOMINA_SALARIO;
-- drop table conceptos;
create table CONCEPTOS
(
Id_Concepto int ,#1
NombreConcepto varchar (80) not null, /*si es igss o es isr */
AfectaConcepto varchar (20) not null,  /*percepcion o deduccion */
TipoConcepto varchar(20) not null, # A : por porcentaje , B : por cuota
valorConcepto varchar(20) not null,   #promedio de cuanto es el igss o isr,
usoTabla varchar(10), #Si usa tabla o no
aplica varchar(20), #A todos o algunos,
CodigoEmpleado int,
primary key(Id_Concepto, NombreConcepto,AfectaConcepto,TipoConcepto, valorConcepto, usoTabla,aplica, CodigoEmpleado),
foreign key(CodigoEmpleado) references DATOS_EMPLEADO(Id_Empleado)
)Engine = InnoDB Default charset = Latin1 ;

#select * from conceptos;

create table IMPUESTO(
	IdImpuesto int,
	NombpreConcepto varchar(30),
    Porcentaje varchar(20), 
    maximo float,
    minimo float,
    primary key(IdImpuesto)

)Engine = InnoDB Default charset = Latin1 ;


create table APLICAR_CONCEPTO(
Id_Aplicar int primary key auto_increment,
Id_Empleado int not null,
Id_Concepto int not null,
foreign key(Id_Empleado) references DATOS_EMPLEADO(Id_Empleado),
foreign key(Id_Concepto) references CONCEPTOS (Id_Concepto),
foreign key(Id_Concepto) references IMPUESTO(IdImpuesto)
)Engine = InnoDB Default charset = Latin1 ;

create table REGISTROS(
IdRegristro int primary key auto_increment,
FechaRegistro date not null,
CodigoUsuario int not null,
CodigoEmpleado int not null,
foreign key(CodigoUsuario) references USUARIOS (IdUsuario),
foreign key(CodigoUsuario) references usuario_administrador (Id_Admin),
foreign key(CodigoEmpleado) references DATOS_EMPLEADO(Id_Empleado)


)Engine = InnoDB Default charset = Latin1 ;



#drop table usuario_administrador;



-- drop database NOMINA_SALARIO;