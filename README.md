# Spring multi DataSource con JNDI

> JNDI (Java Naming and Directory Interface) permite que las aplicaciones distribuidas busquen servicios del servidor en el que se implementan. La configuración de fuentes de datos con JNDI permite que las aplicaciones accedan a la base de datos sin conocer los detalles de la conexión.

Este proyecto sirve de base para la configuración de un servidor de aplicaciones y un entorno de desarrollo Spring boot. Los archivos críticos a revisar:
1.  Configuración de POM
2.  Archivo `application.properties`
3.  Paquete `com.falpema.config`

## Estructura del proyecto

Realice la estructura del proyecto siguiendo la arquitectura MVC. Siga la estructura de acuerdo a la siguiente imagen, donde:
1. En la definición de los paquetes para los modelos anteceder el nombre del origen de datos `com.falpema.vacunacion.entities` y `com.falpema.vacunacion.repository`
2. Mantener separada las clases de configuración y utilidades según su paquete
3. Descripción:
    1.   **Repository:** la consulta de los datos DAO.
    2.   **Entities:** Los modelos mapeados de la base de datos.
    3.   **Controller:** Las clases qué contienen los métodos que se encargaran de procesar las peticiones.
    4.   **Service:** Encargada de la lógica del negocio.
    5.   **Config:** Configuraciones del proyecto.
    6.   **Utils:** Las clases utilitarias que serán utilizadas en todo el proyecto.
    
![Estrucutura MVC](/agrupado.png "Estructura MVC")

### Configuración de proyecto para consumo de servicios y utilización de kafka
>  Apache Kafka ha sido diseñado para optimizar la transmisión y el procesamiento de los flujos de datos que se intercambian entre la fuente y el receptor por conexión directa. Kafka actúa como una entidad de mensajería entre el emisor y el receptor, solventando los inconvenientes más habituales que conlleva este tipo de conexión.

2.   **Dto:** Objeto de transferencia de datos.
3.   **Interfaces:** Colección de métodos abstractos y propiedades constantes.
4.   **Producer:** La API Producer permite que las aplicaciones envíen flujos de datos a los brokers de los clústers de Apache para categorizarlos y almacenarlos (en los topics mencionados anteriormente).
5.   **Consumer:**  la API Consumer proporciona a los consumidores de Apache Kafka acceso de lectura a los datos almacenados en los topics del clúster.

![Estrucutura MVC, WS y KAFKA](/configProyect.PNG "Estructura MVC")

## Configuración

### Wildfly:

* Versión de wildfly 17.0.1
* Pasos:
    1. Configure su archivo module.xml para **Oracle**. 
    2. Configure los `datasources` en el archivo **standalone.xml**
    3. Agregue el driver de **Oracle** a la configuración.

### Spring boot:

* Configuración POM
    * Versión de inicialización de **Spring Boot**
         ```html
            <parent>
        		<groupId>org.springframework.boot</groupId>
        		<artifactId>spring-boot-starter-parent</artifactId>
        		<version>2.1.6.RELEASE</version>
        		<relativePath /> <!-- lookup parent from repository -->
        	</parent>
        ```
    * Agregue la dependencias **javax** necesaria para que se pueda desplegar en el servidor de aplicaciones.
        ```html
            <!-- Esta dependencia permite compilar para jboos -->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
                <scope>provided</scope>
            </dependency>
        ```
    * Empaquetar el proyecto en formato **war** `<packaging>war</packaging>`
    * Realizar el **build** del proyecto de acuerdo al proyecto `<build> ..code.. </build>`.

* Configuración `application.properties` 
    *  Configurar la conexión a la base de datos mediante su **JNDI**
        ```spring
            spring.datasource.primary.jndi-name=java:/bdVacunacion
            spring.jpa.show-sql=true
            
            apiVac.datasource.secondary.jndi-name=java:/bdVacunacion
            apiVac.jpa.show-sql=true 
        ```
* Configuración de **clases**:
    * En el paquete **com.falpema.config** crear una clase por cada JNDI *(Revise la configuración en el proyecto)*. 
        *   apiVacunacion.java 

    * En la clase principal del proyecto **main** realizar la herencia de la clase `extends SpringBootServletInitializer` e implementar el método a sobrescribir
        ```java
            @Override
            	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            		return builder.sources(MayorRestApplication.class);
            	}
        ```
## Objetos de respuesta en servicios REST 
 >  Para la comunicacíon entre los diferentes sistemas de proyecto.

Crear la clase **Java** llamada *GenericResponse* la cual contiene los objetos que responderá el servicio Web
```java
	@Override
	public class GenericResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String message;
	private T object;
			
	public Integer getStatus() {
		if (status == null) { 
			status = ParametersApp.SUCCESSFUL.value();
			}
			return status;
		}
			
		public void setStatus(Integer status) {
			this.status = status;
		}
			
		public String getMessage() {
			if (message == null) {
				if (status != null) {
					message = ParametersApp.resolve(status).getReasonPhrase();
				}	
			}
			return message;
       	}
		//... incluir  getter and setter faltantes
		}
```

Esta clase debe ser implementada con la clase que contiene los estados de respuesta utilices para la comunicación:
_Los códigos estandarizados  se encuentra en la tabla de la base de datos JAVADB  `T_STATUS_RESPONSE`

```java
        public enum ParametersApp {
        
        	SERVER_ERROR(0, "Error en el servidor"),
        	SUCCESSFUL(1, "Exito"),
        	EMPTY_RECORD(2, "Sin registros que mostrar"),
        	PROCESS_NOT_COMPLETED(3, "Tareo o proceso no completada");
        
        	private final int value;
        
        	private final String reasonPhrase;
        
        	ParametersApp(int value, String reasonPhrase) {
        		this.value = value;
        		this.reasonPhrase = reasonPhrase;
        	}
        
        	public int value() {
        		return this.value;
        	}
        
        	public String getReasonPhrase() {
        		return this.reasonPhrase;
        	}
        
        	/**
        	 * Return a string representation of this status code.
        	 */
        	@Override
        	public String toString() {
        		return this.value + " " + name();
        	}
        
        	public static ParametersApp valueOf(int statusCode) {
        		ParametersApp status = resolve(statusCode);
        		if (status == null) {
        			throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        		}
        		return status;
        	}
        
        	public static ParametersApp resolve(int statusCode) {
        		for (ParametersApp status : values()) {
        			if (status.value == statusCode) {
        				return status;
        			}
        		}
        		return null;
        	}
        
        }
```

Fragmento de codigo de ejemplo que responde un objeto TEmpresa *(paquete de service)*:
```java
	public GenericResponse<TEmpresa> getEmpresa(int codEmpresa) {
			GenericResponse<TEmpresa> respt = new GenericResponse<>();

			Optional<TEmpresa> empresa;
			try {
				empresa = repoEmpresa.findById(codEmpresa);
				respt.setStatus(1);
				respt.setObject(empresa.get());
			} catch (NoSuchElementException e) {
				respt.setStatus(0);
				return respt;
			}
			return respt;
	}
```
Metodo que expone el objeto a traves de un **GET** en el paquete *Controller*
```java
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<GenericResponse> getUserByCodigo(@PathVariable("codigo") int codigo) {
		return new ResponseEntity<GenericResponse>(empresaService.getEmpresa(codigo), HttpStatus.OK);
	}
```

## Tipos de Web Service REST usados:

* GET: Es utilizado únicamente para consultar información al servidor, muy parecidos a realizar un SELECT a la base de datos.
* POST: Es utilizado para enviar datos al servidor.
* PUT: Se utiliza para actualizar por completo un registro existente, es decir, es parecido a realizar un UPDATE a la base de datos. 
* PATCH: Este método es similar al método PUT, pues permite actualizar un registro existente, sin embargo, este se utiliza cuando actualizar solo un fragmento del registro y no en su totalidad, es equivalente a realizar un UPDATE a la base de datos. 
* DELETE: Este método se utiliza para eliminar un registro existente, es similar a DELETE a la base de datos. No soporta el envío del payload.
* HEAD: Este método se utiliza para obtener información sobre un determinado recurso sin retornar el registro. Este método se utiliza a menudo para probar la validez de los enlaces de hipertexto, la accesibilidad y las modificaciones recientes.



## Release History

* 0.0.1
    * DEFINICION DE ESTRUCTURA Y CONFIGURACIÓN: Se crea el proyecto de ejemplo
    * Date: 01/10/2020
    * Autor: Fpenaloza
* 0.0.1
    * TASK: 
        * Seguridad en los servicios   
        * Documentacion de web service
    * Work in progress

## Información

–  [falpema.](https://github.com/falpema)
# springApiVacunacion

