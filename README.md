# 

## Project initialization 

This project has been initialized using:

```console
$ spring init \
    --dependencies=web \
    --java-version=17 \
    --build=maven \
    -packaging=jar \
    -type=maven-project \
    -artifact-id=opentelemetry-datadog \
    -group-id=it.sunnyvale.poc \
    opentelemetry-datadog
```

## Build the application

```console
$ mvn package
```

## Application instrumentation and run

Download the OpenTelemetry Java Agent

```console
$ curl \
    -L \
    -o opentelemetry-javaagent.jar \
    https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
```

```console
$ java \
    -javaagent:./opentelemetry-javaagent.jar \
    -jar target/opentelemetry-datadog-0.0.1-SNAPSHOT.jar
    
```