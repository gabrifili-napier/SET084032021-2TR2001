FROM openjdk:latest
COPY ./target/SeMethods_Assesment-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SeMethods_Assesment-1.0-SNAPSHOT-jar-with-dependencies.jar"]