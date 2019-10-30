# Cecocloud
Versió cloud de Cecogest utilitzant les tecnologies Java, Spring Boot i Angular.

## Compilar
```
$ mvn package
```
Una vegada compilat el projecte, el fitxer .jar per a executar l'aplicació es pot trobar a cecocloud-main/target/cecocloud.jar

## Configurar
1. Crear una nova base de dades amb PostgreSQL i inicialitzar amb els següents scripts:
  * cecocloud-main/src/main/resources/schema-postgresql.sql
  * cecocloud-main/src/main/resources/data-postgresql.sql
2. Crear un fitxer application.properties a la mateixa carpeta a on hi ha el fitxer cecocloud.jar. El contingut del fitxer ha de ser el següent:
```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL9Dialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.datasource.url=jdbc:postgresql://DB_HOST/DB_NAME
spring.datasource.username=DB_USER
spring.datasource.password=DB_PASSWD

spring.mail.host=MAIL_HOST
spring.mail.port=MAIL_PORT
spring.mail.username=MAIL_USER
spring.mail.password=MAIL_PASSWD
spring.mail.properties.mail.smtp.from=MAIL_SMTP_FROM
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.ssl.enable=true
spring.mail.properties.mail.smtp.ssl.trust=MAIL_SSL_TRUST
spring.mail.properties.mail.smtp.starttls.enable=true
```

## Executar
```
$ java -jar cecocloud.jar
```
