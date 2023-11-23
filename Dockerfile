FROM maven:3.8.6-openjdk-8 AS maven

WORKDIR /usr/src/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ src/
RUN mvn package -DskipTests

FROM openjdk:8-alpine
ARG JAR_FILE=attendace-staff-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app/

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app

EXPOSE 8181

ENTRYPOINT ["java", "-jar", "attendace-staff-0.0.1-SNAPSHOT.jar"]
