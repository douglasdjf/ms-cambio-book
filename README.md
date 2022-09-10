# Openzipkin/zipkin

Utilizado para registrar logs em microserviços

### executar
```
docker run -p 9411:9411 openzipkin/zipkin:2.23.2
```

url local: http://localhost:9411/

link: https://hub.docker.com/r/openzipkin/zipkin



# Configurar appication.yml

```
spring:
  sleuth:
    sampler:
      probability: 1.0
```