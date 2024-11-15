# Users Service API

---

## Overview

The **Users Service API** is a Spring Boot-based microservice responsible for managing user information in a dedicated PostgreSQL database. This service provides endpoints for retrieving user details, updating user information, and deleting users. It is a part of a larger microservices architecture and uses JWT authentication for securing user-related actions.

## Features

- **Get User Info**: Retrieve detailed user information using the user ID.
- **Update User Info**: Update user details like name and email.
- **Delete User**: Delete a user from the system by their ID.

## Architecture

The **Users Service API** follows a layered architecture:

- **Common**: Contains constants, entities, and data transfer objects (DTOs).
- **Controller**: Defines REST endpoints and maps them to service methods.
- **Repository**: Interacts with the PostgreSQL database for CRUD operations.
- **Service**: Contains the business logic related to user management.

## Folder Structure

```
users-service-api
│
├── common
│   ├── constant
│   ├── dto
│   └── entity
│
├── controller
│   └── impl
│
├── repository
│
└── service
    └── impl
```

- **common**
    - `constant`: Contains the API path constants.
    - `dto`: Contains Data Transfer Objects for request and response data (`UpdateUserRequest`, `UserInfoResponse`).
    - `entity`: Contains the `UserModel` representing the `users` table in the database.
- **controller**
    - `impl`: The controller layer, which handles HTTP requests and maps them to the service methods (`UserController`).
- **repository**
    - The `UserRepository` interface provides methods to interact with the database.
- **service**
    - `impl`: Implements the business logic for user operations (`UserServiceImpl`).

## Endpoints

### 1. **Get User Info**

- **URL**: `/v1/user`
- **Method**: `GET`
- **Headers**:
    - `X-User-Id`: The ID of the user to retrieve.
- **Response**:
    - **200 OK**: Returns user information.
    - **404 Not Found**: If the user ID does not exist.

Example Response:

```json
{
  "id": 1,
  "email": "user@example.com",
  "firstName": "John",
  "lastName": "Doe",
  "role": "USER"
}
```

### 2. **Update User Info**

- **URL**: `/v1/user/update_user_info/{userId}`
- **Method**: `PUT`
- **Headers**:
    - `X-User-Id`: The ID of the user to update.
- **Body**:

    ```json
    {
      "email": "newemail@example.com",
      "firstName": "John",
      "lastName": "Doe"
    }
    ```

- **Response**:
    - **204 No Content**: If the update was successful.
    - **400 Bad Request**: If the request is invalid.
    - **404 Not Found**: If the user ID does not exist.

### 3. **Delete User**

- **URL**: `/v1/user/delete_user/{userId}`
- **Method**: `DELETE`
- **Headers**:
    - `X-User-Id`: The ID of the user to delete.
- **Response**:
    - **204 No Content**: If the deletion was successful.
    - **404 Not Found**: If the user ID does not exist.

## Database Configuration

The service connects to a PostgreSQL database with the following settings:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/email-db
    username: postgres
    password: 1234
  jpa:
    hibernate:
      ddl-auto: update

```

> [!NOTE] 
> Make sure to replace the database URL, username, and password with your actual configuration.

## Technologies Used

- **Spring Boot**: Backend framework for building Java-based microservices.
- **PostgreSQL**: Relational database for storing user data.
- **Spring Data JPA**: For interacting with the PostgreSQL database.
- **Spring Web**: For building RESTful APIs.
- **Lombok**: Used for generating boilerplate code like getters, setters, and constructors.

## Related Microservices

The system consists of multiple microservices that work together to provide comprehensive functionality. Below is a list of all the microservices in the system, with links to their respective repositories:

- [**users-service-api**](https://github.com/juansebstt/users-service-api): Handles user management, including registration, profile updates, and account data.
- [**email-kafka-microservice**](https://github.com/juansebstt/email-kafka-microservice): Manages asynchronous email event processing using Kafka for reliable messaging.
- [**notifications-microservice-api**](https://github.com/juansebstt/notifications-microservice-api): Sends notifications based on triggered events from other services.
- [**email-authentication-service-api**](https://github.com/juansebstt/email-authentication-service-api): Manages email-based authentication and verification processes.
- [**email-api-gateway**](https://github.com/juansebstt/email-api-gateway): Serves as the entry point for routing requests to various microservices.
- [**letter-service-api**](https://github.com/juansebstt/letter-service-api): Manages letters, including creation, storage, and retrieval.
- [**packages-service-api**](https://github.com/juansebstt/packages-service-api): Manages package-related operations, including tracking and status updates.

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/juansebstt/users-service-api
    ```

2. Navigate to the project directory:

    ```bash
    cd users-service-api
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```


The service will be running on `http://localhost:8084`.

## Security

This service is secured via JWT authentication. Ensure that each request includes a valid JWT token in the headers. The `X-User-Id` header is used to identify the user making the request.