FROM openjdk:17-jdk

RUN mkdir /app
COPY build/libs/*.jar /app/application.jar

EXPOSE 5500 15500

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:15500", "-jar", "/app/application.jar"]
