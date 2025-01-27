FROM openjdk:latest
LABEL MAINTAINER Ranvir Rana
EXPOSE 9000
COPY firstproject-0.0.1-SNAPSHOT.jar .
CMD java -jar firstproject-0.0.1-SNAPSHOT.jar