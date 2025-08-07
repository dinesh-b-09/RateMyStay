FROM openjdk:21

WORKDIR /app

COPY target/hotel_docker_app.jar hotel_docker_app.jar

EXPOSE 8091

ENTRYPOINT ["java","-jar","hotel_docker_app.jar"]