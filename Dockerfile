FROM openjdk:latest
COPY ./target/SeMethods_Assesment-0.1-alpha-2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SeMethods_Assesment-0.1-alpha-2-jar-with-dependencies.jar"]