# quarkus-jsf
Testing Quarkus with JSF and PrimeFaces

## TODO
- [ ] Bruke lit-html templating og lit-elemets as basis
- [ ] WC native (pure WebComponents)
- [ ] WC + lit-html
- [ ] WC + lit-elements

## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```
mvn clean quarkus:dev
```

## Running the application
To build a package and start it use
```
mvn clean package -Dmaven.test.skip=true
java -jar target/quarkus-jsf-1.0.0-SNAPSHOT-runner.jar
```

## What does this project do?
It uses `TestContainers` to create a blank postgres database via the JDBC URL
together with a small script to create a table and populate some initial data.

It creates a JSF application on top of the database, testing :
- [ ] [Deep Linking with JSF](https://stackoverflow.com/questions/10724428/how-do-i-process-get-query-string-url-parameters-in-backing-bean-on-page-load)
- [ ] [Old tips for get processing](http://balusc.omnifaces.org/2011/09/communication-in-jsf-20.html)

You can also access the swagger ui to list and create more data.
http://localhost:8080/swagger-ui/

