[![Integração Continuar com GitHub](https://github.com/douglasdjf/ms-cambio-book/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/douglasdjf/ms-cambio-book/actions/workflows/docker-publish.yml)

# Openzipkin/zipkin

Utilizado para registrar logs em microserviços

### Executar
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


