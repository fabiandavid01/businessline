
# Proyecto Base Implementando Clean Architecture

En este documento se explicara las utilidades y responsabilidades del proyecto base de clean architecture, el cual se encuentra en este [repositorio](https://grupobancolombia.visualstudio.com/Vicepresidencia%20Servicios%20de%20Tecnolog%C3%ADa/_git/IngSW_CleanArchitecture)

## Antes de Iniciar
Antes de iniciar a leer esta guía se recomiendo leer la [Guía de Implementación de Clean Architecture](https://grupobancolombia.visualstudio.com/Vicepresidencia%20Servicios%20de%20Tecnolog%C3%ADa/_wiki/wikis/Vicepresidencia%20Servicios%20de%20Tecnolog%C3%ADa.wiki/6842/Gu%C3%ADa-de-implementaci%C3%B3n-de-Clean-Architecture)  y repasaremos algunos conceptos básicos necesarios para llegar a entender el proyecto completo, empecemos:


Ahora bien, empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por último el inicio y configuración de la aplicación.

## Infraestructure

### Helpers
En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos genéricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006) 

En el proyecto base tenemos 2 utilidades las cuales son:


Para las dos ambas utilidades a la hora de implementar clase abstracta debemos satisfacer los datos genericos para su funcionamiento
`public abstract class AdapterOperations<E, D, I, R extends MongoRepository<D, I> & QueryByExampleExecutor<D>>`

Donde:

 - E => Representa la entidad de dominio de negocio.
 - D => Representa la entidad de persistencia (Driven Adapter).
 - I => Representa el tipo de dato llave para la entidad definida en D.
 - R => Repositorio para la ejecución de los métodos base. 

Como ejemplo, el uso de esta clase por parte los Driven Adapters y basados en el proyecto base es de la siguiente forma:

    public class MovieRepositoryAdapter extends AdapterOperations<Movie, MovieData, String, MovieDataRepository>

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**


## Driven Adapters
Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest, soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos interactuar.

Actualmente tenemos 4 proyectos en repositorio base, los cuales son:

### jpa-repository y mongo-repository
En este proyecto hacemos uso de la utilidad **helpers/jpa-repository-commons** o **mongo-repository-commons**. 
Tendremos nuestras entidades acopladas a las anotaciones propias de persistencia *MovieData*
Existirá un repositorio que aparte de poder ejecutar métodos base de la interfaz `CrudRepository` podremos ejecutar queries nativos contra la base de datos, implementando de la interfaz `QueryByExampleExecutor` *MovieDataRepository*.
Por ultimo tendremos una clase *MovieRepositoryAdapter* que implementara la utilidad del helper *AdapterOperations* e implementara los gateways del dominios, con el fin de poder realizar las operaciones definidas por el core de negocio.

###secrets-manager-consumer
Por medio de este proyecto realizamos el consumo de secretos a la nube de AWS, esta implementación se realizó de forma genérica con el fin de poder satisfacer cualquier dato por medio de un modelo genérico, para el repositorio base este modelo es *SecretsModel*

**¿Importante!** actualmente el proyecto se encuentra deshabilitado dado que el consumo de secretos no funciona localmente a menos que se tenga un cuenta de AWS configurada en la maquina, sin embargo se puede habilitar y usar el proyecto a la hora de desplegar la solución en entornos pre productivos y producción 

### techinical-logs-utility
En este proyecto pretendemos dar a los equipos la utilidad para el registro de logs técnicos por medio de la implementación de log4j, sin embargo basado en la necesidad se pueden utilizar diferentes herramientas para el registro de los logs.

## Entry Points
Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio, para el proyecto base tenemos:

### api-rest
En este proyecto nos acoplamos al framework para uso de controladores rest de spring y exponer los comandos identificados en nuestros flujos de negocio


Cabe recalcar que cada una de estas utilidades son proyectos gradle aparte, únicamente con el registro de las dependencias  necesarias para su propio funcionamiento y estos no deben realizar referencias hacía nuestros dominios de negocio