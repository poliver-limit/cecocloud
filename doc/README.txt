-------------
- COMPILACIO:
-------------
- Oracle:
$ mvn package
- PostgreSQL:
$ mvn package -P postgresql,\!oracle
- HypersonicSQL:
$ mvn package -P hsql,\!oracle

El fitxer .jar de l'aplicació es troba a cecocloud-front/target/cecocloud-front-?.?.jar

---------------
- INSTAL·LACIO:
---------------
1.- Crear arxiu cecocloud.service a la carpeta /etc/systemd/system.
2.- Crear l'usuari cecocloud (useradd -M pepet -s /usr/sbin/nologin).
3.- Crear una carpeta /opt/cecocloud.
4.- Copiar el .jar de l'aplicació a dins /opt/cecocloud.
5.- Configurar l'usuari cecocloud com a propietari del fitxer .jar (chown cecocloud ???.jar).
6.- Donar permisos d'execució al fitxer .jar (chmod a+x ???.jar).
7.- Crear el fitxer application.properties a dins /opt/cecocloud amb la configuració de connexió a BBDD i al servidor de correu.

---------
- GESTIÓ:
---------
- Iniciar amb: systemctl start cecocloud
- Aturar amb: systemctl stop cecocloud
- Consultar els logs amb: tail -f /var/log/syslog

------------------
- Proves API REST:
------------------
$ curl -X POST -d '{"codi": "test", "nom": "test", "email": "test@limit.es", "contrasenya": "test", "rols": ["ADMIN"]}' -H "Content-Type: application/json" http://localhost:8080/cecocloud/api/usuaris

$ curl -H "Authorization: Bearer TOKEN" http://localhost:8080/cecocloud/api/usuaris

$ curl -i -H "Content-Type: application/x-www-form-urlencoded" -d "user=test&pass=test" http://localhost:8080/cecocloud/api/auth

$ curl -X POST http://localhost:8080/cecocloud/api/registres/admin@limit.es/reset

Expired token: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJjZWNvY2xvdWQiLCJhdWQiOiJhdXRoIiwic3ViIjoiYWRtaW4iLCJleHAiOjE1NjYwMjIzMTUsIm5hbWUiOiJBZG1pbmlzdHJhZG9yIiwiZW1haWwiOiJhZG1pbkBsaW1pdC5lcyIsInJvbCI6WyJBRE1JTiJdfQ.crW1uMF6lyJRD4Lco0YPgvcfI3nx09BsDrBkKVoimSBee6yRX4Gmd9SvDEZ_oya0VqLw3JzkTX0oJrFz2i5ijw