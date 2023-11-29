# Aplicación de gestión de turnos.



Este proyecto es una aplicación web de gestión de turnos. Se desarrolla con Java + Servlets para el backend, JSP para el frontend y JPA para acceder a la base de datos.

Requisitos

Java 17
Maven
MySQL
Instalación

Clone el repositorio:
git clone https://github.com/EnriqueVOZA/VozmedianoEnrique_PruebaTecnica2
Instale las dependencias:
Cree una base de datos MySQL con el nombre turnosbbdd.

La aplicación se puede acceder en el siguiente URL:

http://localhost:8080
La aplicación tiene dos funciones principales:

Crear un turno: Para crear un turno, complete el formulario en la página /index. 

Los campos obligatorios son nombre, apellido, dni, telefono, tramite, fecha y hora.

Filtrar turnos: Para filtrar turnos, complete el formulario en la página /index. Los campos de filtro son fechaInicio y estado.
 
El código cumple con los siguientes requisitos :

Utilizar colecciones y objetos para gestionar los datos antes de interactuar con la base de datos.
Utilizar en el código funciones lambda, optionals, utils o streams.

Aspectos mejorables:

El apartado de filtrado tiene dos botones, el boton "Filtrar por fecha" ignora el select de estado "Ya atendido" o "En espera" y el boton "Filtrar por estado" lo tiene en cuenta, aquí hay que mejorarlo para que no lleve a confusión.

Los tipos de tramite debieran de ser un desplegable que nos de una seríe de opciones acotadas pues ahora acepta cualquier tipo de String.

En este momento un usuario que quiera distintos tramites recibira distintos nº pero se podría implementar un número de tramite y un id de usuario para que no se duplique en la base de datos.



## Autor

- [@EnriqueVOZA](https://www.github.com/EnriqueVOZA)
