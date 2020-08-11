FROM openjdk:8

ENV SBT_VERSION 1.3.8

RUN \
    curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
    dpkg -i sbt-$SBT_VERSION.deb && \
    rm sbt-$SBT_VERSION.deb && \
    apt-get update && \
    apt-get install sbt

EXPOSE 5432
EXPOSE 8081
WORKDIR /opt/vosmovies_api
ADD . /opt/vosmovies_api
CMD sbt run
