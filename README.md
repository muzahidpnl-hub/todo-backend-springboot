# Todo Backend (Spring Boot)

This repository contains the backend service for the Todo application. It provides a RESTful API to manage todo items, built with Spring Boot and Spring Data JPA.

## Tech Stack

- **Java 17**
- **Spring Boot** (Web, Data JPA)
- **MySQL** (Primary datastore)
- **H2 Database** (Included for in-memory or testing scenarios)
- **Lombok** (Boilerplate reduction)

## Prerequisites

- JDK 17+
- Maven 3.8+
- MySQL Server running locally

## Local Setup

1. **Database Configuration**
   Ensure you have a local MySQL instance running. Create a schema named `tododb`.
   The application defaults to:
   - URL: `jdbc:mysql://localhost:3306/tododb`
   - User: `root`
   - Password: `root`

   *(If your local credentials differ, update `src/main/resources/application.properties` accordingly.)*

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   The service will start on `http://localhost:8081`.

## API Endpoints

All endpoints are mapped under `/api/todos`.

| Method | Endpoint      | Description                            | Request Body |
|--------|---------------|----------------------------------------|--------------|
| GET    | `/hello`      | Health/Sanity check for the service.   | N/A          |
| GET    | `/`           | Retrieve all todo items.               | N/A          |
| POST   | `/`           | Create a new todo item.                | `Todo` JSON  |
| GET    | `/{id}`       | Retrieve a specific todo by ID.        | N/A          |
| DELETE | `/`           | Delete a specific todo item.           | `Todo` JSON  |

### Model Structure (`Todo`)

```json
{
  "id": 1,
  "title": "Example Task",
  "description": "Details about the task",
  "completed": false
}
```

## Data Persistence

- Flyway/Liquibase is currently not set up. The application uses `spring.jpa.hibernate.ddl-auto=update` to manage schema changes automatically during development.
- The `Todo` entity is mapped to the `todos` table in the database.
