insert into PROYECT (name,description,startDate,finishDate, state) values ("Proyect1", "example", "11-01-2002", "11-31-2002", 1)


insert into TASK (name,description, proyect, users, state) values ("Task1","example", 1 , 1, 1)

insert into STATE (name) values ("Created","La tarea fue creado")
insert into STATE (name) values ("In progress","La tarea esta en proceso")
insert into STATE (name) values ("Revision","La tarea esta proxima a ser finalizada")
insert into STATE (name) values ("Finish", "La tarea esta finalizada")