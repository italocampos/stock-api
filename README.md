# Stock-api

A project using Spring Boot, Hibernate, and other technologies to improve my
portifolio.

This project implements a CRUD API using the RESTful concepts and the MVC
archtecture. The application provides endpoints to handle the CRUD operations
with Stock objects. Each Stock has a unique name and a list of quotes. See the
examples below to better understand the actions of this application.

## Enabling a database

To run the project, install and run MySQL in your PC. After, logged as root,
run the script placed in `auxiliary/db_scripts.sql`. If all is right, you can
now compile and run the application.

## Compiling and runing

With Maven installed on your PC, go to the root of the project and run the
`mvn package` command, like this.

``` shell
cd stock-api
mvn package
```

After compiled, all you need is run the application with:

``` shell
java -jar target/stock-api-0.0.1-SNAPSHOT.jar
```

## Using the API

To use the API, send HTTP requests -- following the RESTful principles -- to
the URIs, like the requests below show.

``` HTTP
GET http://localhost:8080/stock

###

POST http://localhost:8080/stock HTTP/1.1
Content-Type: application/json

{
    "name": "petr4",
    "quotes": [
        12.9,
        9.81,
        13.0
    ]
}
```

You can use clients like [Postman](https://www.postman.com/) or REST Client
in [VS Code](https://code.visualstudio.com/) to test this API. To more
examples of test, see the `auxiliary/uri_tests.rest` file.
