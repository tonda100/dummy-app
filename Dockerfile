FROM gcr.io/distroless/java:11

ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV AB_ENABLED=jmx_exporter

COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/app.jar

CMD [ "/deployments/app.jar" ]
