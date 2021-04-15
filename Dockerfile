FROM openjdk:11

USER root
WORKDIR /app/

COPY build/libs/user-service-*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]

#docker build -t hataketed/ws-user-service:1.0.2 .
#docker push hataketed/ws-user-service:1.0.2
