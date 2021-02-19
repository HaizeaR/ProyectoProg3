# ProyectoProg3
Proyecto Programación III

> Miembros del equipo: Unai Mendiondo, Mireya Quintana y Haizea Rodriguez.

Proyecto grupal en el que se desarrolla un programa de gestión de entradas de cine. 
Se han creado distintas ventanas donde el usuario irá seleccionando la película que quiere ver y el horario en el que quiere asistir, entre otras cosas. 
Por otro lado, encontramosla parte del administrador donde un trabajador del cine pueda tener la posibilidad de editar ciertos atributos.

## Objetivos 

Lograr un programa funcional, capaz de permitir al usuario visualizar la cartelera semanal,  seleccionar una película y comparar sus entradas. 

Hacer funciones de administrador, donde ciertos usuarios con carácter de administrador pueden realizar cambios. 


## BD  
Consta de 8 tablas.


ENTIDAD RELACIÓN 
Mediante las relaciones logramos guardar datos sobre las películas que se proyectas, en qué lugar y con qué horario. 


## Libreria Externa 

http://www.java2s.com/Code/JarDownload/itextpdf/itextpdf-5.4.0.jar.zip (Enlace de descarga) 

Se trata de una librería que permite generar un PDF con el formato y los datos que nosotros decidamos incluir. La librería externa se usa para generar documentos denominados TICKETS. 
Como propuesta a futuro se podría incluir otra librería que nos permitan enviar estos documentos a los clientes para así poder presentarlos en el cine. 
El documento se genera tras realizar la compra y pulsar en el botón TICKET. 
De momento se guarda como archivo dentro de nuestra carpeta de proyecto y se actualiza cada vez que se crea uno. 

