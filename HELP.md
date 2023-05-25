# Getting Started
To be used with image igorpavlyushchik/posts-application:1.0.0, nothing to be done here to start.

# To play with the users service without posts service:
kubectl apply -f manifest.yaml
and make some API calls from below
kubectl delete -f manifest.yaml

# For info:
docker build -t igorpavlyushchik/users-application:1.0.0 ./
docker push igorpavlyushchik/users-application:1.0.0

Comment for sub-task 3: Persistent volumes
checkout branch module2_k8s_st3

Create a directory with the file index.html in the node.
kubectl get nodes
kubectl debug node/docker-desktop -it --image=ubuntu //connect from debug node to shared folder in the node
cd host
mkdir /mnt/data
sh -c "echo 'Hello from Kubernetes storage' > /mnt/data/index.html"

kubectl apply -f pv-volume.yaml
kubectl apply -f manifest.yaml

kubectl get all -n=k8s-program
# get a shell to the container running in the pod
kubectl exec -n=k8s-program -it pod/usersapp-pod-84c4cbcf4-rq7bc -- /bin/bash
cd var
cat index.html

Then if we delete the pod or delete the both manifests and apply them again we still can see the files,
and we can create/delete files both from node and from the shell to the pods created with the given pv and pvc.



kubectl delete -f manifest.yaml
kubectl delete -f pv-volume.yaml

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

