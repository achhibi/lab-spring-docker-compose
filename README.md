# Spring Boot 3.3.0 & Docker Compose Integration

This project demonstrates how to integrate Docker Compose with a **Spring Boot 3** application using PostgreSQL as the database and Liquibase for database schema management.

## Prerequisites

Before you begin, ensure you have the following installed:
- Docker
- Docker Compose
- JDK (Java Development Kit)
- Maven or Gradle (depending on your build tool preference)

## Project Structure

The project structure is as follows:

## Springboot & Docker compose integration 

#### **spring configuration properties example**


```
#Set a custom Docker compose file
spring.docker.compose.file=docker-custom.yml

#Configure the lifecycle
#none - Do not start or stop Docker Compose
#start-only - Start Docker Compose when the application starts and leave it running
#start-and-stop - Start Docker Compose when the application starts and stop it when the JVM exits
spring.docker.compose.lifecycle-management=

#By default, Spring Boots Docker Compose support is disabled when running tests. To enable it, set
spring.docker.compose.skip.in-tests=false

#Disable spring-boot-docker-compose feature
spring.docker.compose.enabled=false

#Host or IP of the machine where the docker containers are started
spring.docker.compose.host=

#Set the timeout to stop
spring.docker.compose.stop.timeout=1m
```
## Getting Started

1. **Clone the repository:**

   ```bash
   git clone https://github.com/achhibi/labs-spring-docker-compose.git
   cd labs-spring-docker-compose

2. **Test:**

```bash
curl -X POST http://localhost:8080/employees \
-H "Content-Type: application/json" \
-d '{
"firstName": "Aaa",
"lastName": "Bbb",
"email": "name@example.com",
"phone": "1234567890"
}'

