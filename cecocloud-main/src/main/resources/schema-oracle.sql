create sequence hibernate_sequence start with 1 increment by  1;

create table companyia (
   id number(19,0) not null,
    version number(19,0) not null,
    codi varchar2(30 char) not null,
    email varchar2(120 char),
    llicencia varchar2(2000 char),
    nom varchar2(30 char) not null,
    telefon varchar2(16 char),
    primary key (id)
);

create table empresa (
   id number(19,0) not null,
    version number(19,0) not null,
    activa number(1,0) not null,
    codi varchar2(30 char) not null,
    nif varchar2(12 char) not null,
    nom varchar2(30 char) not null,
    tipus number(10,0) not null,
    identificador_id number(19,0),
    primary key (id)
);

create table identificador (
   id number(19,0) not null,
    version number(19,0) not null,
    codi varchar2(4 char) not null,
    nom varchar2(40 char) not null,
    companyia_id number(19,0),
    primary key (id)
);

create table perfil (
   id number(19,0) not null,
    version number(19,0) not null,
    codi varchar2(30 char) not null,
    descripcio varchar2(255 char) not null,
    companyia_id number(19,0),
    primary key (id)
);

create table perfil_rol (
   perfil_id number(19,0) not null,
    rol_id number(19,0) not null,
    version number(19,0) not null,
    primary key (perfil_id, rol_id)
);

create table perfil_usuariempresa (
   empresa_id number(19,0) not null,
    perfil_id number(19,0) not null,
    usuari_id number(19,0) not null,
    version number(19,0) not null,
    primary key (empresa_id, perfil_id, usuari_id)
);

create table rol (
   id number(19,0) not null,
    version number(19,0) not null,
    codi varchar2(30 char) not null,
    descripcio varchar2(255 char) not null,
    companyia_id number(19,0),
    primary key (id)
);

create table rol_usuariempresa (
   empresa_id number(19,0) not null,
    rol_id number(19,0) not null,
    usuari_id number(19,0) not null,
    version number(19,0) not null,
    primary key (empresa_id, rol_id, usuari_id)
);

create table usuari (
   id number(19,0) not null,
    version number(19,0) not null,
    actiu number(1,0),
    codi varchar2(64 char) not null,
    contrasenya varchar2(255 char),
    email varchar2(100 char) not null,
    imatge_url varchar2(255 char),
    llinatges varchar2(100 char),
    nom varchar2(100 char) not null,
    validat number(1,0),
    primary key (id)
);

create table usuari_authority (
   usuari_id number(19,0) not null,
    rol varchar2(10 char)
);

create table usuari_companyia (
   companyia_id number(19,0) not null,
    usuari_id number(19,0) not null,
    version number(19,0) not null,
    primary key (companyia_id, usuari_id)
);

create table usuari_empresa (
   empresa_id number(19,0) not null,
    usuari_id number(19,0) not null,
    version number(19,0) not null,
    primary key (empresa_id, usuari_id)
);

alter table companyia 
   add constraint companyia_codi_uk unique (codi);

alter table empresa 
   add constraint empresa_uk unique (identificador_id, codi);

alter table identificador 
   add constraint identificador_uk unique (companyia_id, codi);

alter table perfil 
   add constraint perfil_uk unique (companyia_id, codi);

alter table rol 
   add constraint rol_uk unique (companyia_id, codi);

alter table usuari 
   add constraint usuari_codi_uk unique (codi);

alter table usuari 
   add constraint usuari_email_uk unique (email);

alter table empresa 
   add constraint empresa_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table identificador 
   add constraint identificador_companyia_fk 
   foreign key (companyia_id) 
   references companyia;

alter table perfil 
   add constraint perfil_companyia_fk 
   foreign key (companyia_id) 
   references companyia;

alter table perfil_rol 
   add constraint perfilrol_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table perfil_rol 
   add constraint perfilrol_rol_fk 
   foreign key (rol_id) 
   references rol;

alter table perfil_usuariempresa 
   add constraint perfilusuemp_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table perfil_usuariempresa 
   add constraint perfilusuemp_usuemp_fk 
   foreign key (usuari_id, empresa_id) 
   references usuari_empresa;

alter table rol 
   add constraint rol_companyia_fk 
   foreign key (companyia_id) 
   references companyia;

alter table rol_usuariempresa 
   add constraint rolusuemp_rol_fk 
   foreign key (rol_id) 
   references rol;

alter table rol_usuariempresa 
   add constraint rolusuemp_usuemp_fk 
   foreign key (usuari_id, empresa_id) 
   references usuari_empresa;

alter table usuari_authority 
   add constraint usuaut_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_companyia 
   add constraint usucom_companyia_fk 
   foreign key (companyia_id) 
   references companyia;

alter table usuari_companyia 
   add constraint usucom_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_empresa 
   add constraint usuemp_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table usuari_empresa 
   add constraint usuemp_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

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
