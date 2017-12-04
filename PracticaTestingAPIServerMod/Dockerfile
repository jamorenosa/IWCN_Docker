FROM java:8
MAINTAINER Jose Angel Moreno San Segundo
EXPOSE 1234
VOLUME /tmp
ADD /target/PracticaSpringAPIServer-0.0.1-SNAPSHOT.jar practicajose.jar
ENTRYPOINT ["java", "-jar", "practicajose.jar"]