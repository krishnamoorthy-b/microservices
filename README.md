### Microservice

#### API Documentation

##### Verify Token
- URL -> http://localhost:8080/security/auth/token/verify
- Request Method -> POST
- Request Body -> Token string as payload

##### Generate Token
- Note: This API intensionally not secured for educational purpose
- URL -> http://localhost:8080/security/auth/token
- Request Method -> GET

##### Content API
- URL -> http://localhost:8080/content/courses
- Request Method -> GET
- Request Header -> Header name is **Authorize** and value is **token**.

#### Architecture

![microservice drawio (1)](https://github.com/krishnamoorthy-b/microservices/assets/25192795/0894e239-627e-44f2-9216-7ba64514b403)

#### Libraries
- Spring Cloud Gateway
- Spring Security
- Netflix Eureka Server
- Netflix Eureka Client
- JWT

#### ToDo
- [ ] Token expiry logic
