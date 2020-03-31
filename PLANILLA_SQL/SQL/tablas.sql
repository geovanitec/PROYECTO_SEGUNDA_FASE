create database nomina_sql;
use nomina_sql;


create table registro(

CodigoEmpleado int primary key,
NombreEmpleado varchar (50) not null,
PuestoEmpleado varchar (50) not null,
SalarioEmpleado float not null,
SalarioExtraordinario float not null,
Bonificacion float not null,
Comision float not null,
Otros float not null,
#TotalDevengados float not null,
#Igss float not null,
#Isr float not null,
Anticipos float not null,
DescuentosJudiciales float not null,
OtrosDescuentos float not null
#TotalDescuentos float not null,
#TotalLiquido float not null


)Engine = InnoDB Default charset = Latin1 ;

#drop nomina_sql;
