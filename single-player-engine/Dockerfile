FROM openjdk:11

ADD ./target/single-player-engine-0.0.1-SNAPSHOT.jar /event/src/single-player-engine-0.0.1-SNAPSHOT.jar
EXPOSE 8095
WORKDIR event/src
ENTRYPOINT ["java","-jar","single-player-engine-0.0.1-SNAPSHOT.jar"]

