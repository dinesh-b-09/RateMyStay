FROM openjdk:21

WORKDIR /app

COPY target/rating_docker_app.jar rating_docker_app.jar

EXPOSE 8092

ENTRYPOINT ["java","-jar","rating_docker_app.jar"]