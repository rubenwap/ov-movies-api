FROM openjdk:8

ENV SBT_VERSION 1.3.8

RUN \
    curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
    dpkg -i sbt-$SBT_VERSION.deb && \
    rm sbt-$SBT_VERSION.deb && \
    apt-get update && \
    apt-get install sbt


WORKDIR /opt/vosmovies_api
ADD . /opt/vosmovies_api
CMD sbt assembly

FROM openjdk:8-alpine

EXPOSE 8081
WORKDIR /opt/vosmovies_api
COPY --from=0 /opt/vosmovies_api/target/scala-2.12/vosmovies_api-assembly-0.1.jar .

ENTRYPOINT ["java", "-jar", "vosmovies_api-assembly-0.1.jar"]
