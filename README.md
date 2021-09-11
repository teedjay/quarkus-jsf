# quarkus-jsf
Testing Quarkus with JSF (MyFaces) and PrimeFaces

## TODO
- [x] Adding Primeflex and Primeblocks
- [ ] WC native (pure WebComponents)
- [ ] [Deep Linking with JSF](https://stackoverflow.com/questions/10724428/how-do-i-process-get-query-string-url-parameters-in-backing-bean-on-page-load)
- [ ] [Old tips for get processing](http://balusc.omnifaces.org/2011/09/communication-in-jsf-20.html)
- [ ] Test out lit-html templating with lit-elements as basis

## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```
./mvnw clean quarkus:dev
```

## Running the application
To build a package and start it from command line do
```
./mvnw clean package -Dmaven.test.skip=true
java -jar target/quarkus-app/quarkus-run.jar
```

## What does this project do?
It uses Quarkus dev services to create a postgres database with some initial data
and server crud and jsf on top of that.
```
open http://localhost:8080/index.xhtml
```

You can access the swagger-ui to create more data or manipulate existing. 
```
open http://localhost:8080/q/swagger-ui/
```
