# OpenTelemetry to DataDog

Reference: https://docs.datadoghq.com/opentelemetry/otel_collector_datadog_exporter/?tab=onahost

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

## Download and run the OpenTelemetry Collector Datadog Exporter

Pick the OTEL contrib collector that suites your OS/Arch.

```console
$ curl -L -o otelcol-contrib_0.78.0_darwin_arm64.tar.gz https://github.com/open-telemetry/opentelemetry-collector-releases/releases/download/v0.78.0/otelcol-contrib_0.78.0_darwin_arm64.tar.gz
```

Untar the binary and run it 

```console
$ tar -xvzf otelcol-contrib_0.78.0_darwin_arm64.tar.gz otelcol-contrib
$ chmod 755 otelcol-contrib
$ export DD_API_KEY=<REPLACE WITH YOUR API KEY> ./otelcol-contrib --config collector.yaml
```

Make sure that in the collector's log file, this line appears:

```
2023-05-30T00:57:09.462+0200    info    clientutil/api.go:44    API key validation successful.  {"kind": "exporter", "data_type": "logs", "name": "datadog"}
```

## Application instrumentation and run

Download the OpenTelemetry Java Agent

```console
$ curl \
    -L \
    -o opentelemetry-javaagent.jar \
    https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
```

Run the application with `-javaagent` flag

```console
$ java \
    -javaagent:./opentelemetry-javaagent.jar \
    -jar target/opentelemetry-datadog-0.0.1-SNAPSHOT.jar
 
```