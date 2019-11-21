INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, "version")
VALUES(nextval('hibernate_sequence'),'admin','$2a$10$lLGi1t0OT7ftruz8ieC2B.ImwpGTlkVCHDiYrQKTYdlOr6fN/CFMa','admin@limit.es',NULL,'Administrador','Admin',true,true,'init',current_timestamp,0);
INSERT INTO usuari_authority VALUES(1,'ADMIN');
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, "version")
VALUES(nextval('hibernate_sequence'),'test','$2a$10$DOpxYy8VGZcKnW6aA9y4uO17KpIMFCpZRqlYjHFlFo5R/pM354g52','test@limit.es',NULL,'Test','Test',true,true,'init',current_timestamp,0);
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, "version")
VALUES(nextval('hibernate_sequence'),'sync','$2a$10$j.zqnsIS6LEM/0hhIbTfS.gxd80WMl3nx0azivywrIdnTkRhrOghG','sync@limit.es',NULL,'Sincronitzacio','CECOGEST',true,true,'init',current_timestamp,0);
INSERT INTO usuari_authority VALUES(3,'SYNC');
