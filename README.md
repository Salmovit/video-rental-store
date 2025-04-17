<h1 align="center">
  Video Rental Store
</h1>

Simple REST API of a video rental store, developed mostly as a test for further projects.


## Technologies
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Mysql](https://dev.mysql.com/downloads/)

## Skills used

- API REST
- Queries with Spring Data JPA
- Dependency injection
- Error handling

## How to run

- Clone the git repository
- Build the package:
```
$ ./mvnw clean package
```
- Run the Application:
```
$ java -jar target/video-store-0.0.1-SNAPSHOT.jar
```

The API can be accessed at [localhost:8080](http://localhost:8080).


## API Endpoints

For the HTTP requests the tool [httpie](https://httpie.io) was used:

- Create Movie
```
$ http POST :8080/movies title="Movie 1" description="Desc movie 1" genre=ACTION releaseYear=2000

{
    "description": "Desc movie 1",
    "genre": "ACTION",
    "id": 1,
    "releaseYear": 2000,
    "title": "Movie 1"
}
```

- List Movies
```
$ http GET :8080/movies

[
  {
    "description": "Desc movie 1",
    "genre": "ACTION",
    "id": 1,
    "releaseYear": 2000,
    "title": "Movie 1"
  }
]
```

- Update Movie
```
$ http PUT :8080/movies/1 title="Movie 1 Up" description="Desc movie 1 Up"  genre=ACTION releaseYear=2000

{
    "description": "Desc movie 1 Up",
    "genre": "ACTION",
    "id": 1,
    "releaseYear": 2000,
    "title": "Movie 1 Up"
}
```

- Delete Movie
```
http DELETE :8080/movies/1


```