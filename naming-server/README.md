# Docker Maven Build

### Alterar o pom.xml

```
    <configuration>
        <image>
            <name>doug397/${project.artifactId}:${project.version}</name>
        </image>
        <pullPolicy>IF_NOT_PRESENT</pullPolicy>
    </configuration>
```

### Necessário para buildar a imagem docker
```
mvn spring-boot:build-image -DskipTests
```

### Executar a imagem docker gerada sem docker-compose
```
docker run -p 8761:8761 doug397/naming-server:0.0.1-SNAPSHOT
```

OBS: a principio foi gerada doug397/naming-server:0.0.1-SNAPSHOT porém depende das informaçoes implementadas no pom.xml


### IMPORTANTE: Aqui o processo é feito baseado no pelo maven docker