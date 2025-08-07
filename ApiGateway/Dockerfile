FROM openjdk:21

WORKDIR /app

COPY target/gateway_docker_app.jar gateway_docker_app.jar

EXPOSE 8093

ENTRYPOINT ["java","-jar","gateway_docker_app.jar"]




