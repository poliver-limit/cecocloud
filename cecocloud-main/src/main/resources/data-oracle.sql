INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, version)
VALUES(hibernate_sequence.nextval,'admin','$2a$10$lLGi1t0OT7ftruz8ieC2B.ImwpGTlkVCHDiYrQKTYdlOr6fN/CFMa','admin@limit.es',NULL,'Administrador','Admin',1,1,'init',current_timestamp,0);
INSERT INTO usuari_authority 
VALUES(hibernate_sequence.currval,'ADMIN');
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, version)
VALUES(hibernate_sequence.nextval,'test','$2a$10$DOpxYy8VGZcKnW6aA9y4uO17KpIMFCpZRqlYjHFlFo5R/pM354g52','test@limit.es',NULL,'Test','Test',1,1,'init',current_timestamp,0);
