# Java Spring Boot MongoDB
## 🔧 Tech Stack
- Spring Boot
- MongoRepository
- MongoTemplate
- ModelMapper
- Pagination
- Mail Sending
- Validation
- GlobalExceptionHandler 
##  ⚡ HOW TO RUN
- First step is clone the project with : 
``` git clone https://github.com/MET-DEV/Java-Spring-Boot-MongoDB-Example.git ```
- Second step is up your mongo image with :
```  docker run -d -p 27017:17017 --name app_db mongo ```
- Third step is up the project with:
```docker run -p 8080:8080 --name myapp --link app_db:mongo -d myapp:1.0```
## :white_check_mark: And check project running state from swagger 
- Swagger Url : ``` http://localhost:8080/swagger-ui/index.html# ```

