FROM openjdk:latest
COPY ./target/SeMethods_Assesment-0.1-alpha-5-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SeMethods_Assesment-0.1-alpha-5-jar-with-dependencies.jar", "db:3306"]