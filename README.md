# Spring Boot WebFlux R2DBC Application
![banner](./assets/banner.jpg)

# Running Postgres from Docker
```bash
$ docker run --rm -p 5432:5432 -e POSTGRES_PASSWORD=admin postgres:13.1-alpine -d postgres
```

# Testing
- Create New Author </br>
`POST /authors` </br>
    ```json
    {        
        "name": "David A. Pereira"
    }
    ```

- Create New Book </br>
`POST /books` </br>
    ```json
    {
        "idAuthor": "1efcf599-116f-1fb6-cf3c-13d7528b7fb7",
        "title": "Harry Potter: Hogwarts Mystery",
        "dateOfParution": "2021-11-28"
    }
    ```