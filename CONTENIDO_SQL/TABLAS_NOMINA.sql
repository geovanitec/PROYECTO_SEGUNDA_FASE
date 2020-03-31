create database NOMINA_SALARIO;
use NOMINA_SALARIO;


create table PUESTO
(
IdPuesto int primary key,
NombrePuesto varchar (30) not null


)Engine = InnoDB Default charset = Latin1 ;

create table USUARIOS(
IdUsuario int primary key,
NombreUsuario varchar (30) not null,
FechaIngreso date not null
)Engine = InnoDB Default charset = Latin1 ;

create table DEPARTAMENTO
(
IdDepartamento int primary key,
NombreDepartamento varchar (30) not null
)Engine = InnoDB Default charset = Latin1 ;

create table CONCEPTOS
(
IdConcepto int primary key,
NombreConcepto varchar (20) not null,
AfectaConcepto varchar (1) not null,
valorConcepto float not null,
TipoConcepto varchar(1) not null,
#aca se determina si es tipo fijo o no 
AplicarConcepto varchar (8) not null

)Engine = InnoDB Default charset = Latin1 ;

create table DATOS_EMPLEADO
(
IdEmpleado int primary key,
CodigoPuesto int not null,
CodigoDepartamento int not null,
NombreEmpleado varchar (20) not null,
ApellidoEmpleado varchar (20) not null,
EdadEmpleado int (5) not null,
EstadoEmpleado varchar(20) not null,
SalarioEmpleado float not null,
foreign key(CodigoDepartamento) references DEPARTAMENTO (IdDepartamento),
foreign key(CodigoPuesto) references PUESTO (IdPuesto)

)Engine = InnoDB Default charset = Latin1 ;

create table REGISTROS(
IdRegristro int primary key,
FechaRegistro date not null,
CodigoUsuario int not null,
CodigoEmpleado int not null,
foreign key(CodigoUsuario) references USUARIOS (IdUsuario),
foreign key(CodigoEmpleado) references DATOS_EMPLEADO(IdEmpleado)


)Engine = InnoDB Default charset = Latin1 ;

create table DEVENGADOS
(
IdDevengados int primary key,
SalarioExtraordinario float not null,
Bonificacion float not null,
Comision float not null,
OtrosDescuentos float not null,
TotalDevengado float not null,
CodigoEmpleado int not null,
foreign key(CodigoEmpleado) references DATOS_EMPLEADO(IdEmpleado)
)Engine = InnoDB Default charset = Latin1 ;

create table DESCUENTOS 
(
IdDescuentos int primary key,
#Igss float not null,
#Isr float not null,
Anticipos float not null,
DescuentosJudiciales float not null,
OtrosDescuentos float not null,
TotalDescuentos float not null,
CodigoEmpleado int not null,
foreign key (CodigoEmpleado) references DATOS_EMPLEADO(IdEmpleado)
)Engine = InnoDB Default charset = Latin1 ;

create table CONTABILIDAD 
(
IdContabilidad int primary key,
#ControlEmpleado int not null,
ControlDescuentos int not null,
ControlDevengados int not null,
#foreign key(ControlEmpleado) references DATOS_EMPLEADO (IdEmpleado),
foreign key(ControlDescuentos) references DESCUENTOS(IdDescuentos),
foreign key(ControlDevengados) references DEVENGADOS(IdDevengados)

)Engine = InnoDB Default charset = Latin1 ;

