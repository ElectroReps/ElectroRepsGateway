# ElectroReps
## About this project
Electroreps is a simple API, based on a microservice architecture and relational databases, that allow to manage an electronic device reparation service.
Clients can be registered, and register a new reparation for an electronic device that will be linked to the employee that will work on the reparation.
There are three main data entities used in the system :
  - Client : an entitiy that holds client information such as its name and email
  - Employee : an entity that hold the employee name
  - Reparation : an entity that represents each reparation and relates the client and the employee through their respectives ids, and also holds information of the reparation itself like its state and an extended description of the issue.
## UML Entities Diagram

The following UML class diagram show the relations of the several enbtities

![uml](https://github.com/user-attachments/assets/1e7c352e-85c5-47e9-85db-ded10c5fc2e5)


## Microservices architecture
The microservice architecture chosen for the projects its the following. Each service has its own repository.
### ElectroRepsGateway
This repository is used as the main repository. The gateway allows to centralize the routes into a single route

- Project Setup : 

  In order to set the project running after cloning, an application.properties must be configured as the following example : 

    ```properties
  spring.application.name=electroreps-gateway
  server.port=8087
  eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
  spring.main.web-application-type=reactive
  ```

  To run the project, execute the program through the IDE or build it into a jar file.

- Technologies
  - Spring Reactive Gateway
  - Eureka (client) 

### ElectroRepsDiscoveryService

Repo on : https://github.com/ElectroReps/ElectroRepsDiscoveryService

This repo is used as a discovery serrvice for the microservices, allowing them to find the other services and centalizing them.

- Project Setup : 

  In order to set the project running after cloning, an application.properties must be configured as the following example : 

    ```properties
  spring.application.name=electroreps-discovery-service
  server.port=8761
  ```

  To run the project, execute the program through the IDE or build it into a jar file.

- Technologies
  - Spring Reactive Gateway
  - Eureka (server)

### ElectroRepsClientService

Repo on : https://github.com/ElectroReps/ElectroRepsClientService

This repo is the microservice that hold the Client enities, its corresponding database, and give acces to the CRUD operations through the API.

- Project Setup : 

  In order to set the project running after cloning, an application.properties must be configured as the following example : 

    ```properties
  spring.application.name=electroreps-client-service
  server.port=8081
  spring.datasource.url=jdbc:mysql://localhost:3306/electroreps_clients
  spring.datasource.username=exampleusername
  spring.datasource.password=examplepassword
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
  eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
  spring.jpa.hibernate.ddl-auto=update
  ```

  To run the project, execute the program through the IDE or build it into a jar file.

- Routes
  - The main route is : /clients
  - The routes that require parameters are :
    - /clients?name=
    - /clients/?email=
  - The route that require an id to acces a specific resource are : /clients/numberId 

- Technologies
  - Spring Boot 3.5.0
  - Spring web
  - Spring Data JPA (Hibernate)
  - Spring Validation
  - MySQL
  - Eureka (client)

### ElectroRepsEmployeeService

Repo on : https://github.com/ElectroReps/ElectroRepsEmployeeService

This repo is the microservice that hold the Employee enities, its corresponding database, and give acces to the CRUD operations through the API.

- Project Setup : 

  In order to set the project running after cloning, an application.properties must be configured as the following example : 

    ```properties
  spring.application.name=electroreps-employee-service
  server.port=8080
  spring.datasource.url=jdbc:mysql://localhost:3306/electroreps_employees
  spring.datasource.username=exampleusername
  spring.datasource.password=examplepassword
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
  eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
  spring.jpa.hibernate.ddl-auto=update
  ```

  To run the project, execute the program through the IDE or build it into a jar file.

- Routes
  - The main route is : /employees
  - The routes that require parameters are :
    - /employees?name=
  - The route that require an id to acces a specific resource are : /employees/numberId 

- Technologies
  - Spring Boot 3.5.0
  - Spring web
  - Spring Data JPA (Hibernate)
  - Spring Validation
  - MySQL
  - Eureka (client)

### ElectroRepsReparationService
Repo on : https://github.com/ElectroReps/ElectroRepsReparationtService

This repo is the microservice that hold the Reparation enities, its corresponding database, and give access to the CRUD operations through the API. As the Reparation entity relies on data of the Client and Employee entities, this microservice make request to the other microservices through FeignClients.

- Project Setup : 

  In order to set the project running after cloning, an application.properties must be configured as the following example : 

    ```properties
  spring.application.name=electroreps-reparation-service
  server.port=8082
  spring.datasource.url=jdbc:mysql://localhost:3306/electroreps_reparations
  spring.datasource.username=exampleusername
  spring.datasource.password=examplepassword
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
  eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
  spring.jpa.hibernate.ddl-auto=update
  ```

  To run the project, execute the program through the IDE or build it into a jar file.

- Routes
  - The main route is : /reparations
  - The routes that require parameters are :
    - /reparations?clientId=
    - /reparations?employeeId=
    - /reparation?finished=
  - The route that require an id to acces a specific resource are : /reparations/numberId 

- Technologies
  - Spring Boot 3.5.0
  - Spring web
  - Spring Data JPA (Hibernate)
  - Spring Validation
  - MySQL
  - Eureka (client)
  - OpenFeign

## Extra links
- Trello : https://trello.com/b/qdeJq0Rv/electroreps
- Google Sldes : https://docs.google.com/presentation/d/1Uc33Grhw334lXXOZ_sK7m4oUTJfZf1UXScmnki08-Ss/edit?usp=sharing
- Postman Collction : https://blue-zodiac-9830536.postman.co/workspace/My-Workspace~cd30aadd-1e2d-4b26-8f3b-eccef1d322c6/collection/44618249-a203c2fa-8ccc-4c92-a179-af314721a3cf?action=share&creator=44618249
## Future work
Some of the features that could be implemented in the future as an improvement of the system are :
- Implementation of security layers and role hierarchy with authentication and authorization
- Creation of users as the reparation is created through POST requests.
- Web Fronted in order to create a usable MVP as a webapp
## References
- PlantUML : https://plantuml.com/es/
- Baeldung (Spring Boot info and examples) : https://www.baeldung.com/spring-boot 
## Contact
- Alvaro Gonzalez Alcazar : https://www.linkedin.com/in/alvarogonzalezal/
