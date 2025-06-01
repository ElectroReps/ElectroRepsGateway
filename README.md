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
## Microservices architecture
The microservice architecture chosen for the projects its the following. Each service has its own repository.
### ElectroRepsGateway
### ElectroRepsDiscoveryService
### ElectroRepsClientService
### ElectroRepsEmployeeService
### ElectroRepsReparationService
## Extra links
## Future work
Some of the features that could be implemented in the future as an improvement of the system are :
- Creation of users as the reparation is created through POST requests.
- Web Fronted in order to create a usable MVP as a webapp
## References
- Trello : https://trello.com/b/qdeJq0Rv/electroreps
- Google Sldes : https://docs.google.com/presentation/d/1Uc33Grhw334lXXOZ_sK7m4oUTJfZf1UXScmnki08-Ss/edit?usp=sharing
## Contact
- Alvaro Gonzalez Alcazar : https://www.linkedin.com/in/alvarogonzalezal/
