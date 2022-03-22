FROM openjdk:latest
COPY ./target/SeMethods-V1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SeMethods-V1-jar-with-dependencies.jar", "db:3306"]

