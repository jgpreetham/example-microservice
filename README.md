# example-microservice
Example Microservice

##Description

1. A simple micro service with REST API’s to perform CRUD operation on user details using
In-memory database i.e h2 
Note :  Insert 2 users in h2 db during the start-up to perform the above operations

2. Validation of the incoming request to validate the user id is only numeric.

3. Entry/exit logging for the project

4. Perform Basic User authentication and authorization for these end points.

5. Role based access
Eg: Admin user can perform read/write operations.
    Non-admin user has read only access.



#### Basic Authentication Credentials
|Username   | Password  | Role  | Method  |
|---|---|---|---|
|  admin |admin   | Admin  | GET,PUT,POST,DELETE |
|  user | user   |  User | GET|


### Request and Responses
#### Create User Details
![POST](https://user-images.githubusercontent.com/16732168/89156207-a1de9980-d5ad-11ea-9468-c72c97108123.PNG)
#### Update User Details
![PUT](https://user-images.githubusercontent.com/16732168/89156210-a30fc680-d5ad-11ea-8fa9-78e830070b01.PNG)
#### Delete User Details
![Delete](https://user-images.githubusercontent.com/16732168/89156217-a440f380-d5ad-11ea-90de-0cbdfe5d8602.PNG)
#### Get User Details
![Get-2](https://user-images.githubusercontent.com/16732168/89156221-a4d98a00-d5ad-11ea-9358-667be8448dcb.PNG)
#### Get All User Details
![Get-All](https://user-images.githubusercontent.com/16732168/89156222-a5722080-d5ad-11ea-89d1-eb55d515bf08.PNG)

### Error Scenarios
#### User with Id already exists
![UserIdExists](https://user-images.githubusercontent.com/16732168/89156214-a3a85d00-d5ad-11ea-86e5-c293e6b643de.PNG)
#### User Id should always be numeric
![UserIdNumeric](https://user-images.githubusercontent.com/16732168/89156216-a3a85d00-d5ad-11ea-9fa6-417ce2ba0ca2.PNG)
#### User with Id not found
![NotFound](https://user-images.githubusercontent.com/16732168/89156227-a5722080-d5ad-11ea-94ed-83abc31d16b7.PNG)
#### Invalid Username/Password
![Unauthorized](https://user-images.githubusercontent.com/16732168/89156211-a30fc680-d5ad-11ea-811a-f15fe91efa47.PNG)
#### User doesn't have access to this method, should use Admin user
![Forbidden](https://user-images.githubusercontent.com/16732168/89156220-a4d98a00-d5ad-11ea-9dbd-917236700c0f.PNG)



### How to access H2 console
http://localhost:8080/console/

```
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```
#### H2 Console UI
![DB](https://user-images.githubusercontent.com/16732168/89153479-4827a080-d5a8-11ea-81bf-8e0f3aee5367.PNG)

#### Query execution
![Query](https://user-images.githubusercontent.com/16732168/89154744-d69d2180-d5aa-11ea-9550-3f3999ed07d7.PNG)


### How to access Swagger UI
http://localhost:8080/swagger-ui.html

#### Swagger UI
![Swagger](https://user-images.githubusercontent.com/16732168/89153935-40b4c700-d5a9-11ea-850e-86cd30f6a6e6.PNG)

#### Request execution
![swagger-run](https://user-images.githubusercontent.com/16732168/89155062-78247300-d5ab-11ea-84db-6c87156be096.png)

