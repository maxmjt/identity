# Identity users Project

El proyecto tiene los siguientes modules:

## Identity Persistence
Este modulo es responsable de hacer operaciones con la base de datos.

## Identity Client
Este modulo es responsable de conectarse con la perssitencia y tambien esta pensado para que pueda interactuar con otros servicios.

## Identity Parent
This module is to deploy the artifacts it creates in the package phase of the build.
It needs to define the repository information where the packaged artifacts will be deployed.

## Identity Modules
Este modulo contiene los frameworks o grandes librerias.

## Identity Service
Este modulo es responsable de ejecutar la logica del negocio de cada requrimiento.

## Project Dependencies

##### 1.  Java SDK 8 or later
For more details please visit [Download Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html).
```shell
$ java -version
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```

##### 2.  Maven 3.0 or later
For more details please visit [Download Maven](http://maven.apache.org/download.cgi).
```shell
$ mvn --version
Apache Maven 3.5.0 (...)
Maven home: ...
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: ...
Default locale: ...
OS name: ...
```

## Configurations

##### bootstrap.yml
The location of the configuration file is:  
`identity\identity-service\src\main\resources\application.yml`

+  Default configurations:

~~~~{.yml}
spring:
  application:
    name: mio-identity
~~~~

## Pre Build Project

##### Clone the project from git repository.
    $ git clone https://git.digitalharbor.us/set/social-common.git

## Build Artifacts

##### 1.  Build Social Chat
   For build the artifact social.chat.patent return to '\identity' folder and execute the console commands:
    
   + __Execute the following command to remove the target directory with all the build data before starting so that it is fresh__:
   ```
   $  mvn clean
   ```
    
   + __Execute the following command to compile your application sources__: 
   ```
   $  mvn compile
   ```
     
   + __Execute the following command to make a JAR file of project__: 
   ```
   $  mvn package
   ```
    
   After that java executable file 'social.chat-${version}' is generated in folder '/chat-service/target'

Note.- The ${version} corresponds with project pom.xml file.

##### Dev-Ops Mode

1.  Build the artifacts.
2.  The Cloud Registry Server already must be started.
3.  Update the social-chat.yml default configurations according the dev-ops deployment plan in Cloud Config Server.
4.  Reload all configurations in Cloud Config Server.
5.  Startup the Cloud Chat Persistence Services (provided by Set-Fusion)
6.  Execute the command: `java -jar chat-service/target/chat-service-${version}.jar`

Note.- The ${version} corresponds with project pom.xml file.

## Testing

To run the chat model unit tests you need execute the command:

$ mvn test

To run the chat model fusion integration tests you need:

- Update the integration-test profile into the application.yml configuration file, it is located in folder 'chat-model/src/test/resources/'

- run the next command:

$ mvn test -P integration-test


## Project Browser Url
The project browser is available on:

```
http://localhost:9595/
```

## Swagger Url

+ __Chat Swagger Url__: 

```
http://localhost:9595/swagger-ui.html
```

## End-point Examples

### Creation of a Chat

For the creation of a Chat, you can use swagger UI, previously detailed.

We have available the creation of __individual__ conversations and __group__ conversations.

For __individual__ conversation we make a POST request to the following path:

```
http://localhost:9090/set/social-services/chat/swagger-ui.html#!/user-rest-controller/createIndividualConversationUsingPOST
```

End-Point 
```
http://localhost:9090/set/social-services/chat/users/{userId}/conversations/createIndividual
```

The request will make use of the __userId__ parameter required and obtained from the social-identity service, also a request body that will be sent in json content type as follows:

~~~~{.json}
{
  "appResourceId": "string",
  "internalUser": [
    {
      "firstName": "string",
      "lastName": "string",
      "name": "string",
      "userId": ${userId}
    }
  ],
  "resourceId": "string",
  "resourceUUID": "string"
}
~~~~

For __group__ conversation we make a POST request to the following path:

```
http://localhost:9090/set/social-services/chat/swagger-ui.html#!/user-rest-controller/createGroupConversationUsingPOST
```

Where:

- HOST - MongoDB instance host.
- PORT - MongoDB instance port.
- DATABASE_NAME - MongoDB database name connection.
- FILE_NAME - Script that you want to run.
