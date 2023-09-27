
Create Database Agenda;
Go
use Agenda;
Go
CREATE TABLE Login(
Usuario varchar(45) PRIMARY KEY,
contrasenia varchar(45)
);
Go
CREATE TABLE Contacto(
Id_Contacto int IDENTITY (1,1) PRIMARY KEY,
Nombre varchar(50) NOT NULL,
Apellido1 varchar(50)  NULL,
Correo varchar(50) NOT NULL,
Telefono varchar(8) NOT NULL,
Direcion varchar(150) NOT NULL,
Usuario varchar(45),
FOREIGN KEY(Usuario)REFERENCES Login(Usuario)
);
Go

insert into Login values ('carlos','123456');
insert into Login values ('lucia','123456');
insert into Login values ('mario','123456');
Go
insert into Contacto values('Yesenia','Escobar','yesenia.escobar@udb.edu.sv','22222222','UDB','lucia');
insert into Contacto values('Luis','Rosales','luis.rosales@udb.edu.sv','55555555','UDB','carlos');
insert into Contacto values('Evelyn','Majano','evelyn.majano@ues.edu.sv','77777777','UES','mario');
insert into Contacto values('Melissa','Merino','melimerino@cdb.edu.sv','75817004','CDB','carlos');
