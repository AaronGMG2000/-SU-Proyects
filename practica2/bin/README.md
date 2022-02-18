# Practica 2

### Descripción
Esta aplicación tiene como función el entendimiento de los conceptos basicos de JPA junto con servicios REST para la generación de una API en Spring Boot utilizando Oracle como servidor de Base de Datos.

### Versión 
versión snapshot.0.0.1

### Requerimientos
* Windows 10 o Superior o cualquier Distro de Linux
* Java 8 o superior
* Maven
* Docker

### Guía para la instalación
1. Abrir una terminal con la ubicación de la aplicación.
2. Correr el Siguiente comando:
    `$ mvn clean install package`
    Este servira para generar el ejecutable funcional de la aplicación.

3. Generación de la imagen del programa por medio de Docker con el siguiente comando:
    `$ docker build -t <image-name> .`
4. Crear y correr un contenedor de docker basada en la imagen creada anteriormente:
    `$ docker run -p <local-port>:<project-port> <image-name>`

### Funcionamiento
Tras tener el contenedor corriendo en docker la aplicación ya sera completamente utilizable por medio de peticiones REST desde cualquier aplicación externa. para probar el buen funcionamiento del programa correr el siguiente comando en postman con una petición get
    `http://localhost:<local-port>/cliente/buscar`
lo cual nos debe devolver una lista de clientes.

### Tecnologias y librerias usadas
Para la creación del proyecto fueron necesarias las siguientes teconologias y librerias:

* Oracle Driver
* Spring Data JPA
* ModelMapper V2.4.4
* Lombok
* Spring Web

### Posibles errores
* Error de pruebas unitarias al compilar el proyecto con Maven.
    * **Corrección**: Revisar el correcto funcionamiento de la base de datos y conección a la misma, en caso de tener error por los datos faltantes dentro de la base de datos, solicitar el script de generación de datos correspondiente.

### Preguntas Frecuentes

### Autor
*Nombre*: Rudy Aarón Gopal Marroquín Garcia