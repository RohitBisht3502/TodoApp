# <h1 align = "center">  Todo Application API </h1>
___ 
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
</a>
    <img alt = "License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
    </a>
</p>


---

<p align="left">

## Overview

The Todo Management Application is a robust web application built on the Spring Boot framework, dedicated to efficient task management. Users can seamlessly perform CRUD (Create, Read, Update, Delete) operations on their tasks, ensuring a streamlined approach to organizing and completing to-dos. The application employs a secure authorization system, requiring users to confirm their identity through a token sent to their registered email upon sign-in. This token plays a pivotal role in authorizing and authenticating users during various interactions with the system. Elevate your productivity with the Todo Management Application, combining user-friendly task management with top-notch security features.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven
- **Cloud Services:** Amazon Web Services (AWS)
- **Database:** MySql
## Data Flow

### Controller

The Controller layer is responsible for handling incoming HTTP requests and delegating them to the appropriate services. It defines API endpoints for the following operations:

1. **User Sign Up:** `Sign Up /users`
   
   This endpoint creates a user it is like as sign up in the system.

   ```java
   @PostMapping("users")
   public String userSignUp(@RequestBody User newUser) {
       
   }
   ```

2. **User Sign In:** `Sign In /users`
   
   This endpoint received user email and password for sign in the system .

   ```java
   @PostMapping("users")
   public String userSignIn(@RequestBody User newUser) {
       
   }
   ```
3. **User Sign Out:** `Sign Out /users`
   
   This endpoint received user email and password for sign out in the system .

   ```java
   @DeleteMapping("users")
   public String userSignOut(@RequestBody User newUser) {
       
   }
   ```

4. **Add Todo:** `TODO /Create todo`
   This endpoint adds a new todo to the system and also recieved user email and token value for verify authentication.

   ```java
   @PostMapping("todo")
   public String createTodo(@RequestParam String email,@RequestParam String tokenValue, @RequestBody Todo todo){
     
    }
   ```

5. **Get Todo:** `GET /todo`

   This endpoint get all the todo by its ID.

   ```java
   @GetMapping("todo/{todoId}")
   public String getTodoById(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer todoId){
    }
   ```

6. **Update Todo Status:** `PUT /post/id/{id}/todoStatus/{todoStatus }`

   This endpoint updates the location of a post by its ID and needs a authentication for apply the changes in any task.

   ```java
   @PutMapping("BlogPost/Location/{location}/{postId}")
   public String updatePostLocationByPostId(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long 
   postId,@PathVariable String location){

    }

   ```

7. **Delete Todo:** `DELETE /Todo/{id}`

   This endpoint deletes a todo by its ID.

   ```java
   @DeleteMapping("todo/{id}")
   public String deletePost(@PathVariable Integer id) {
       
   }
   ```
8. **Get Todo:** `GET Pending todo /todoStatus`

   This endpoint get all the todo by its todo status.

   ```java
   @GetMapping("todo/{todoStatus}")
    public List<String> getCommentByPostId(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Boolean todoStatus){
      
    }
   ```
   
### Services

The Services layer implements the core business logic, data processing, and interaction with the data repository. Key responsibilities include:

- Validating input data.
- Performing CRUD operations on restaurant data.
- Handling data transformations and interactions with external systems (if applicable).

### Repository

The Repository layer manages data access to the underlying database. It handles database operations such as Create, Read, Update, and Delete (CRUD) for restaurant data. Additionally, it may include data mapping and conversion between Java objects and database entities.

### User Class

The `User` class defines the structure for user data and includes the following fields:

- userId (Type: Long): An identifier for the user.
- userName (Type: String): The user's full name.
- userHandle (Type: String): A unique handle or username associated with the user, often used for identification or public display.
- userEmail (Type: String): The email address associated with the user's account.
- userPassword (Type: String): The password used for user authentication and access control.
- userGender (Type: Gender): A variable representing the user's gender, which may be defined as an enumeration or a custom data type.
- 
### Todo Class

The `Todo` class defines the structure for task data and includes the following fields:

- todoId (Type: Integer): An identifier for the todo.
- todoName (Type: String): The name or title of the todo.
- todoStatus (Type: boolean): A boolean indicating the status (completed or not) of the todo.
- todoDescription (Type: String): A description providing additional details about the todo.


### Type Enum

The `Gender Type` enum enumerates the possible types:

- `MALE`: 
- `FEMALE`: 
- `TRANS`: 
- ...

### MySql

The project utilizes the `MYSql` database to store and manage lists of `users` ,`post`,`comment` objects in various parts of the application. `MySql` provides permanent storage and efficient element retrieval, making it suitable for storing blog records and performing operations on them.

These database enable the application to organize and manipulate blog data efficiently while maintaining data integrity.

## Project Summary

A Todo API System in Spring Boot is a web application designed to facilitate the management of tasks through a set of RESTful APIs. Leveraging the efficiency of Spring Boot, a widely-used Java framework, this system enables users to seamlessly create, read, update, and delete todo items. Here's an overview of the key features and components typically present in a Todo API System built with Spring Boot:

Key Features:

- RESTful API endpoints for efficient todo management.
- Comprehensive data validation to maintain data integrity.
- Clear code separation using a layered architecture (Controller, Services, Repository).
- Robust error handling mechanisms for enhanced reliability.
- Java-based backend implementation with Maven for streamlined build management.

  
The Todo Management Application serves as a practical illustration of Spring Boot application development, showcasing best practices in API design and user task management. It provides a solid foundation for constructing and expanding todo management systems across diverse applications.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

Thank you to the Spring Boot and Java communities for providing excellent tools and resources.

## Contact
For questions or feedback, please contact [Rohit singh bisht](mailto:business.rohitbisht3502@gmail.com)
