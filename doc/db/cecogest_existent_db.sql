create sequence hibernate_sequence start with 1 increment by  1;

create table agrupacio (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(8 char) not null,
    descripcio varchar2(100 char) not null,
    modul varchar2(4 char) not null,
    pare_id number(19,0),
    primary key (id)
);

create table agrupacio_ident (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    agrupacio_id number(19,0) not null,
    identificador_id number(19,0) not null,
    primary key (id)
);

create table empresa (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    activa number(1,0) not null,
    codi varchar2(4 char) not null,
    nif varchar2(12 char) not null,
    nom varchar2(30 char) not null,
    tipus number(10,0) not null,
    empresa_comptable_id number(19,0),
    identificador_id number(19,0) not null,
    primary key (id)
);

create table funcionalitat (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(12 char) not null,
    descripcio varchar2(100 char) not null,
    modul varchar2(4 char) not null,
    tipus number(10,0) not null,
    pare_id number(19,0),
    primary key (id)
);

create table funcionalitat_ident (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    funcionalitat_id number(19,0) not null,
    identificador_id number(19,0) not null,
    primary key (id)
);

create table funcionalitat_ident_perfil (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    permis varchar2(20 char) not null,
    funcionalitat_identificador_id number(19,0) not null,
    perfil_id number(19,0) not null,
    primary key (id)
);

create table funcionalitat_recurs (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    principal number(1,0) not null,
    funcionalitat_id number(19,0) not null,
    recurs_id number(19,0) not null,
    primary key (id)
);

create table identificador (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(4 char) not null,
    data_fi timestamp not null,
    data_inici timestamp not null,
    descripcio varchar2(40 char) not null,
    llicencia varchar2(2000 char) not null,
    llicencia_ok number(1,0) not null,
    num_empreses number(10,0) not null,
    num_operaris number(10,0) not null,
    num_usuaris number(10,0) not null,
    propietari_id number(19,0) not null,
    primary key (id)
);

create table operari (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    actiu number(1,0) not null,
    codi varchar2(6 char) not null,
    identificador_id number(19,0) not null,
    usuari_id number(19,0) not null,
    primary key (id)
);

create table operari_empresa (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    actiu number(1,0) not null,
    empresa_id number(19,0) not null,
    operari_id number(19,0) not null,
    primary key (id)
);

create table perfil (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(10 char) not null,
    descripcio varchar2(100 char) not null,
    identificador_id number(19,0) not null,
    primary key (id)
);

create table perfil_usuidentemp (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    perfil_id number(19,0) not null,
    usuidentemp_id number(19,0) not null,
    primary key (id)
);

create table recurs (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    class_name varchar2(1024 char) not null,
    nom varchar2(100 char) not null,
    primary key (id)
);

create table usuari (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    actiu number(1,0) not null,
    codi varchar2(64 char) not null,
    contrasenya varchar2(255 char),
    email varchar2(100 char) not null,
    imatge_url varchar2(255 char),
    llinatges varchar2(100 char) not null,
    nom varchar2(100 char) not null,
    validat number(1,0) not null,
    primary key (id)
);

create table usuari_authority (
   usuari_id number(19,0) not null,
    rol varchar2(10 char)
);

create table usuari_ident (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    actiu number(1,0) not null,
    identificador_id number(19,0) not null,
    usuari_id number(19,0) not null,
    primary key (id)
);

create table usuari_ident_empresa (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    empresa_id number(19,0) not null,
    usuident_id number(19,0) not null,
    primary key (id)
);

alter table agrupacio 
   add constraint agrupacio_uk unique (codi, modul);

alter table agrupacio_ident 
   add constraint agrupident_uk unique (agrupacio_id, identificador_id);

alter table empresa 
   add constraint empresa_uk unique (identificador_id, codi);

alter table funcionalitat 
   add constraint funcionalitat_uk unique (codi, modul);

alter table funcionalitat 
   add constraint UK_9aqspr95hqb6mrebw71voe6k8 unique (codi);

alter table funcionalitat_ident 
   add constraint funcident_uk unique (funcionalitat_id, identificador_id);

alter table funcionalitat_ident_perfil 
   add constraint funcidfperf_uk unique (funcionalitat_identificador_id, perfil_id, permis);

alter table funcionalitat_recurs 
   add constraint funcrecu_uk unique (funcionalitat_id, recurs_id);

alter table identificador 
   add constraint UK_c8mx10mybbuxdqkxre2xw40sn unique (codi);

alter table operari 
   add constraint operari_codi_uk unique (identificador_id, codi);

alter table operari 
   add constraint operari_usuari_uk unique (identificador_id, usuari_id);

alter table operari_empresa 
   add constraint operariemp_uk unique (operari_id, empresa_id);

alter table perfil 
   add constraint perfil_uk unique (identificador_id, codi);

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_uk unique (perfil_id, usuidentemp_id);

alter table recurs 
   add constraint UK_byygig6iys9sraj7oua9nnd74 unique (class_name);

alter table usuari 
   add constraint usuari_codi_uk unique (codi);

alter table usuari 
   add constraint usuari_email_uk unique (email);

alter table usuari_ident 
   add constraint usuident_uk unique (usuari_id, identificador_id);

alter table usuari_ident_empresa 
   add constraint usuidentemp_uk unique (usuident_id, empresa_id);

alter table agrupacio 
   add constraint agrupacio_pare_fk 
   foreign key (pare_id) 
   references agrupacio;

alter table agrupacio_ident 
   add constraint agrupident_agrupacio_fk 
   foreign key (agrupacio_id) 
   references agrupacio;

alter table agrupacio_ident 
   add constraint agrupident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table empresa 
   add constraint empresa_comptable_fk 
   foreign key (empresa_comptable_id) 
   references empresa;

alter table empresa 
   add constraint empresa_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table funcionalitat 
   add constraint funcionalitat_pare_fk 
   foreign key (pare_id) 
   references funcionalitat;

alter table funcionalitat_ident 
   add constraint funcident_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table funcionalitat_ident 
   add constraint funcident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table funcionalitat_ident_perfil 
   add constraint funcidfperf_funcidf_fk 
   foreign key (funcionalitat_identificador_id) 
   references funcionalitat_ident;

alter table funcionalitat_ident_perfil 
   add constraint funcidfperf_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table funcionalitat_recurs 
   add constraint funcrecu_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table funcionalitat_recurs 
   add constraint funcrecu_recurs_fk 
   foreign key (recurs_id) 
   references recurs;

alter table identificador 
   add constraint identificador_propietari_fk 
   foreign key (propietari_id) 
   references usuari;

alter table operari 
   add constraint operari_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table operari 
   add constraint operari_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table operari_empresa 
   add constraint operariemp_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table operari_empresa 
   add constraint operariemp_operari_fk 
   foreign key (operari_id) 
   references operari;

alter table perfil 
   add constraint perfil_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_usuidentemp_fk 
   foreign key (usuidentemp_id) 
   references usuari_ident_empresa;

alter table usuari_authority 
   add constraint usuaut_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_ident 
   add constraint usuident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table usuari_ident 
   add constraint usuident_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_ident_empresa 
   add constraint usuidentemp_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table usuari_ident_empresa 
   add constraint usuidentemp_usuidf_fk 
   foreign key (usuident_id) 
   references usuari_ident;

create table marcatge (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    data timestamp not null,
    latitud double precision,
    longitud double precision,
    origen number(10,0) not null,
    operariemp_id number(19,0) not null,
    primary key (id)
);

alter table marcatge 
   add constraint marcatge_operariemp_fk 
   foreign key (operariemp_id) 
   references operari_empresa;

create table tlic_config (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    filcpv varchar2(1000 char),
    filprv varchar2(1000 char),
    sinact number(1,0) not null,
    empresa_id number(19,0) not null,
    primary key (id)
);

create table tlic_cpv (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(10 char) not null,
    descripcio varchar2(255 char) not null,
    licitacio_id number(19,0) not null,
    primary key (id)
);

create table tlic_document (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(5 char) not null,
    hash varchar2(30 char) not null,
    nom varchar2(200 char) not null,
    tipus number(10,0) not null,
    uri varchar2(255 char) not null,
    licitacio_id number(19,0) not null,
    primary key (id)
);

create table tlic_licitacio (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(200 char) not null,
    datact timestamp not null,
    datlim timestamp,
    destac number(1,0) not null,
    esborr number(1,0) not null,
    expest varchar2(4 char) not null,
    expeds varchar2(100 char) not null,
    expid varchar2(100 char) not null,
    nota varchar2(2000 char),
    prctip varchar2(3 char) not null,
    prctds varchar2(1000 char) not null,
    impnot number(17,2) not null,
    imptot number(17,2) not null,
    mon varchar2(3 char) not null,
    paicod varchar2(2 char),
    paides varchar2(200 char),
    prvcod varchar2(5 char),
    prvdes varchar2(200 char),
    prjsub varchar2(4 char),
    prjsds varchar2(1000 char),
    terexn number(10,0),
    terexu varchar2(3 char),
    prjtip varchar2(4 char) not null,
    prjtds varchar2(1000 char) not null,
    prjtit varchar2(2000 char) not null,
    resum varchar2(500 char) not null,
    unidi3 varchar2(9 char),
    uninom varchar2(200 char) not null,
    unitip varchar2(2 char) not null,
    unitds varchar2(100 char) not null,
    urgtip varchar2(2 char) not null,
    urgtds varchar2(1000 char) not null,
    uri varchar2(255 char) not null,
    url varchar2(200 char) not null,
    empresa_id number(19,0) not null,
    primary key (id)
);

alter table tlic_config 
   add constraint configuracio_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table tlic_cpv 
   add constraint cpv_licitacio_fk 
   foreign key (licitacio_id) 
   references tlic_licitacio;

alter table tlic_document 
   add constraint document_licitacio_fk 
   foreign key (licitacio_id) 
   references tlic_licitacio;

alter table tlic_licitacio 
   add constraint licitacio_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

CREATE TABLE ACL_SID (
    ID NUMBER(18) PRIMARY KEY,
    PRINCIPAL NUMBER(1) NOT NULL CHECK (PRINCIPAL IN (0, 1 )),
    SID NVARCHAR2(128) NOT NULL,
    CONSTRAINT ACL_SID_UNIQUE UNIQUE (SID, PRINCIPAL)
);
CREATE SEQUENCE ACL_SID_SQ START WITH 1 INCREMENT BY 1 NOMAXVALUE;
CREATE OR REPLACE TRIGGER ACL_SID_SQ_TR BEFORE INSERT ON ACL_SID FOR EACH ROW
BEGIN
    SELECT ACL_SID_SQ.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

CREATE TABLE ACL_CLASS (
    ID NUMBER(18) PRIMARY KEY,
    CLASS NVARCHAR2(128) NOT NULL,
    CONSTRAINT ACL_CLASS_UNIQUE UNIQUE (CLASS)
);
CREATE SEQUENCE ACL_CLASS_SQ START WITH 1 INCREMENT BY 1 NOMAXVALUE;
CREATE OR REPLACE TRIGGER ACL_CLASS_ID_TR BEFORE INSERT ON ACL_CLASS FOR EACH ROW
BEGIN
    SELECT ACL_CLASS_SQ.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

CREATE TABLE ACL_OBJECT_IDENTITY(
    ID NUMBER(18) PRIMARY KEY,
    OBJECT_ID_CLASS NUMBER(18) NOT NULL,
    OBJECT_ID_IDENTITY NVARCHAR2(64) NOT NULL,
    PARENT_OBJECT NUMBER(18),
    OWNER_SID NUMBER(18),
    ENTRIES_INHERITING NUMBER(1) NOT NULL CHECK (ENTRIES_INHERITING IN (0, 1)),
    CONSTRAINT ACL_OBJECT_IDENTITY_UNIQUE UNIQUE (OBJECT_ID_CLASS, OBJECT_ID_IDENTITY),
    CONSTRAINT ACL_OBJECT_IDENTITY_PARENT_FK FOREIGN KEY (PARENT_OBJECT) REFERENCES ACL_OBJECT_IDENTITY(ID),
    CONSTRAINT ACL_OBJECT_IDENTITY_CLASS_FK FOREIGN KEY (OBJECT_ID_CLASS) REFERENCES ACL_CLASS(ID),
    CONSTRAINT ACL_OBJECT_IDENTITY_OWNER_FK FOREIGN KEY (OWNER_SID) REFERENCES ACL_SID(ID)
);
CREATE SEQUENCE ACL_OBJECT_IDENTITY_SQ START WITH 1 INCREMENT BY 1 NOMAXVALUE;
CREATE OR REPLACE TRIGGER ACL_OBJECT_IDENTITY_ID_TR BEFORE INSERT ON ACL_OBJECT_IDENTITY FOR EACH ROW
BEGIN
    SELECT ACL_OBJECT_IDENTITY_SQ.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

CREATE TABLE ACL_ENTRY (
    ID NUMBER(18) NOT NULL PRIMARY KEY,
    ACL_OBJECT_IDENTITY NUMBER(18) NOT NULL,
    ACE_ORDER INTEGER NOT NULL,
    SID NUMBER(18) NOT NULL,
    MASK INTEGER NOT NULL,
    GRANTING NUMBER(1) NOT NULL CHECK (GRANTING IN (0, 1)),
    AUDIT_SUCCESS NUMBER(1) NOT NULL CHECK (AUDIT_SUCCESS IN (0, 1)),
    AUDIT_FAILURE NUMBER(1) NOT NULL CHECK (AUDIT_FAILURE IN (0, 1)),
    CONSTRAINT ACL_ENTRY_UNIQUE UNIQUE (ACL_OBJECT_IDENTITY, ACE_ORDER),
    CONSTRAINT ACL_ENTRY_OBJECT_FK FOREIGN KEY (ACL_OBJECT_IDENTITY) REFERENCES ACL_OBJECT_IDENTITY (ID),
    CONSTRAINT ACL_ENTRY_ACL_FK FOREIGN KEY (SID) REFERENCES ACL_SID(ID)
);
CREATE SEQUENCE ACL_ENTRY_SQ START WITH 1 INCREMENT BY 1 NOMAXVALUE;
CREATE OR REPLACE TRIGGER ACL_ENTRY_ID_TRIGGER BEFORE INSERT ON ACL_ENTRY FOR EACH ROW
BEGIN
    SELECT ACL_ENTRY_SQ.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, version)
VALUES(hibernate_sequence.nextval,'admin','$2a$10$lLGi1t0OT7ftruz8ieC2B.ImwpGTlkVCHDiYrQKTYdlOr6fN/CFMa','admin@limit.es',NULL,'Administrador','Admin',1,1,'init',current_timestamp,0);
INSERT INTO usuari_authority 
VALUES(hibernate_sequence.currval,'ADMIN');
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, version)
VALUES(hibernate_sequence.nextval,'test','$2a$10$DOpxYy8VGZcKnW6aA9y4uO17KpIMFCpZRqlYjHFlFo5R/pM354g52','test@limit.es',NULL,'Test','Test',1,1,'init',current_timestamp,0);
