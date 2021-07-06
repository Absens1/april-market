# april-market
Набросок магазина на Spring Boot + AngularJS + JWT


## Preview
![project preview](https://b.radikal.ru/b34/2107/84/dbb42c20de87.png)

## Run Spring Boot application
```
mvn spring-boot:run
```


## Test auth properties
```
username: user
password: 100
```


## Dependency
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-redis</artifactId>
		</dependency>

		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>3.6.0</version>
		</dependency>

		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>

		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>6.1.5.Final</version>
		</dependency>
```


## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.yaml`
```yaml
server:
  port: 8189
  servlet:
    context-path: /market
spring:
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:mydatabase;MODE=PostgreSQL
    username: sa
    password:
  jpa:
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
  h2:
    console:
      enabled: true
      settings:
        web-allow-others: false
  session:
    store-type: redis
  redis:
    host: localhost
    password:
    port: 6379
```
Open `src/main/resources/app.properties`
```properties
jwt.secret=93hf2938hf948hf948hf984ht89h439th849rh849rh439r8h4389h4fn94f
jwt.expirationMs= 3600000
```
