FROM openjdk:21

WORKDIR /app

COPY target/eureka_docker_app.jar eureka_docker_app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","eureka_docker_app.jar"]