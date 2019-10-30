INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, validat, actiu, "version") VALUES(1,'admin','$2a$10$lLGi1t0OT7ftruz8ieC2B.ImwpGTlkVCHDiYrQKTYdlOr6fN/CFMa','admin@limit.es',NULL,'Administrador',true,true,0);
INSERT INTO usuari_rols VALUES(1,'ADMIN');
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, validat, actiu, "version") VALUES(2,'test','$2a$10$DOpxYy8VGZcKnW6aA9y4uO17KpIMFCpZRqlYjHFlFo5R/pM354g52','test@limit.es',NULL,'Test',true,true,0);
INSERT INTO usuari_rols VALUES(2,'MARCA');
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, validat, actiu, "version") VALUES(3,'sync','$2a$10$j.zqnsIS6LEM/0hhIbTfS.gxd80WMl3nx0azivywrIdnTkRhrOghG','sync@limit.es',NULL,'Sincronitzacio CECOGEST',true,true,0);
INSERT INTO usuari_rols VALUES(3,'SYNC');
ALTER SEQUENCE hibernate_sequence RESTART WITH 4;
