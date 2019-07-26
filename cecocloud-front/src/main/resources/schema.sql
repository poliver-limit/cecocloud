/*
create sequence hibernate_sequence start with 1 increment by  1;

create table companyia (
   id number(19,0) not null,
    codi varchar2(30 char) not null,
    nom varchar2(30 char) not null,
    version number(19,0) not null,
    primary key (id)
);

create table empresa (
   id number(19,0) not null,
    codi varchar2(30 char) not null,
    identificador_codi varchar2(255 char),
    nif varchar2(255 char),
    nom varchar2(30 char) not null,
    version number(19,0) not null,
    companyia_id number(19,0) not null,
    primary key (id)
);

create table marcatge (
   id number(19,0) not null,
    data timestamp not null,
    data_actual timestamp not null,
    version number(19,0) not null,
    usuemp_id number(19,0) not null,
    primary key (id)
);

create table usuari (
   id number(19,0) not null,
    codi varchar2(64 char) not null,
    contrasenya varchar2(255 char),
    email varchar2(100 char) not null,
    imatge_url varchar2(255 char),
    nom varchar2(100 char) not null,
    validat number(1,0),
    version number(19,0) not null,
    primary key (id)
);

create table usuari_empresa (
   id number(19,0) not null,
    data_fi timestamp not null,
    data_inici timestamp not null,
    operari_codi varchar2(6 char) not null,
    version number(19,0) not null,
    usuari_id number(19,0) not null,
    empresa_id number(19,0) not null,
    primary key (id)
);

create table usuari_rols (
   usuari_id number(19,0) not null,
    rol varchar2(10 char)
);

alter table usuari 
   add constraint usuari_codi_uk unique (codi);

alter table usuari 
   add constraint usuari_email_uk unique (email);

alter table empresa 
   add constraint empresa_companyia_fk 
   foreign key (companyia_id) 
   references companyia;

alter table marcatge 
   add constraint marcatge_usuemp_fk 
   foreign key (usuemp_id) 
   references usuari_empresa;

alter table usuari_empresa 
   add constraint usuemp_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_empresa 
   add constraint usuemp_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table usuari_rols 
   add constraint usurol_usuari_fk 
   foreign key (usuari_id) 
   references usuari;
*/