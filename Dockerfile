FROM openjdk:21

WORKDIR /tms-club-app

COPY build/libs/tms-club-app-0.0.1-SNAPSHOT.jar tms-club-app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "tms-club-app.jar" ]