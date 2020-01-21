# quarkus-jsf project
This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```
mvn clean quarkus:dev
```

## What does this project do?
It uses `TestContainers` to create a blank postgres database via the JDBC URL
together with a small script to create a table and populate some data.

You can access the swagger ui to list and create more data.
http://localhost:8080/swagger-ui/
