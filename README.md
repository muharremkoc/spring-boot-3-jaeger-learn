The aim of this project is to learn how to use Jaeger in Spring Boot 3 Microservices


## Installation
- Run docker-compose up -d

```
version: "4.0"
services:
  jaeger:
    image: jaegertracing/all-in-one:latest
    container_name: jaeger
    ports:
      - 4318:4318
      - 16686:16686
    environment:
      - COLLECTOR_OTLP_ENABLED=true
```

- We define the necessary dependencies (for User-Service)
```java
 </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-otel</artifactId>
        </dependency>

        <dependency>
            <groupId>io.opentelemetry</groupId>
            <artifactId>opentelemetry-exporter-otlp</artifactId>
        </dependency>

        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-otlp</artifactId>
            <scope>runtime</scope>
        </dependency>

```

- We define the necessary dependencies (for Wallet-Service)

```java
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-otel</artifactId>
        </dependency>

        <dependency>
            <groupId>io.opentelemetry</groupId>
            <artifactId>opentelemetry-exporter-otlp</artifactId>
        </dependency>

        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-otlp</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <version>3.1.5</version>
        </dependency>

        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-micrometer</artifactId>
            <version>12.3</version>
        </dependency>

```



## Configuration
 
- First, we make the necessary edits to the application.properties files

```java
management.otlp.tracing.endpoint=http://localhost:4318/v1/traces
management.tracing.sampling.probability=1.0
management.endpoints.web.exposure.include=health
```

- Secondly, we make the necessary arrangements to create Span for the TraceConfiguration object

   [TraceConfiguration](https://github.com/muharremkoc/spring-boot-3-jaeger-learn/blob/master/user-service/src/main/java/com/spring/service/userservice/config/TraceConfiguration.java)


## Using

- Get Request "http://localhost:2329/user/{id}"

![User-Sercixe-One](https://github.com/muharremkoc/spring-boot-3-jaeger-learn/assets/80245013/8cd4976e-0607-4099-af24-8663f2aa42c7)


- Post Request "http://localhost:2330/wallet?currency=TRY"

![Wallet-Service_Two](https://github.com/muharremkoc/spring-boot-3-jaeger-learn/assets/80245013/d740190d-ef30-4095-8b8d-c7955fae61a5)


[Muharrem Koç](https://github.com/muharremkoc)
