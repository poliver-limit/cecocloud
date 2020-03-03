INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, version)
VALUES(hibernate_sequence.nextval,'admin','$2a$10$lLGi1t0OT7ftruz8ieC2B.ImwpGTlkVCHDiYrQKTYdlOr6fN/CFMa','admin@limit.es',NULL,'Administrador','Admin',1,1,'init',current_timestamp,0);
INSERT INTO usuari_authority 
VALUES(hibernate_sequence.currval,'ADMIN');
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, version)
VALUES(hibernate_sequence.nextval,'test','$2a$10$DOpxYy8VGZcKnW6aA9y4uO17KpIMFCpZRqlYjHFlFo5R/pM354g52','test@limit.es',NULL,'Test','Test',1,1,'init',current_timestamp,0);

--
-- Importar IDFs
--
/*
insert into identificador(
id, codi, descripcio, propietari_id,
data_inici, data_fi, num_empreses, num_usuaris, num_operaris, created_by, created_date, version)
select 
    hibernate_sequence.nextval,
    idf_cod, idf_nom,
    1, sysdate, sysdate + 10000, 10, 10, 10,
    'admin', idf_datcre, 0
from tges_idf;
*/

--
-- Importar empreses associades amb un IDF
--
/*
insert into empresa(
id, codi, nif, nom, tipus, origen, activa, identificador_id, created_by, created_date, version)
select
hibernate_sequence.nextval,
emp_cod, emp_nif, emp_nomcom, 0, 0, 1,
(select id from identificador where codi = emp_idf_cod),
'admin', sysdate, 0
from tges_emp
WHERE emp_idf_cod = '0000';
*/

--
-- Associar totes les funcionalitats amb un IDF
--
/*
insert into funcionalitat_ident(
id, funcionalitat_id, identificador_id, created_by, created_date, version)
select
hibernate_sequence.nextval,
id, (select id from identificador where codi = '0000'),
'admin', sysdate, 0
from funcionalitat;
*/
