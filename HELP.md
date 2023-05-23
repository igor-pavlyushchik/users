# Getting Started
To be used with image igorpavlyushchik/posts-application:1.0.0, nothing to be done here to start.

for info:
docker build -t igorpavlyushchik/users-application:1.0.0 ./
docker push igorpavlyushchik/users-application:1.0.0

To run locally only this service with k8s:
from k8s folder run to start/delete:
kubectl apply -f manifest.yaml
kubectl delete -f manifest.yaml

to check:
kubectl get all -n=k8s-program
kubectl describe service usersapp -n=k8s-program

to test:
GET: localhost:32315/greeting
POST: localhost:32315/users
{
"userName": "some-username k8s 3"
}
GET: http://localhost:32315/users/1
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

