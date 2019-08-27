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
    activa number(1,0) not null,
    version number(19,0) not null,
    companyia_id number(19,0) not null,
    primary key (id)
);

create table marcatge (
   id number(19,0) not null,
    data timestamp not null,
    usuemp_id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
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
    actiu number(1,0),
    version number(19,0) not null,
    primary key (id)
);

create table usuari_empresa (
   id number(19,0) not null,
    data_fi timestamp not null,
    data_inici timestamp not null,
    codi varchar2(6 char) not null,
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

/*
create sequence hibernate_sequence start with 1 increment by 1;

create table companyia (
   id bigint not null,
    codi varchar(30) not null,
    nom varchar(30) not null,
    version bigint not null,
    primary key (id)
);

create table empresa (
   id bigint not null,
    version bigint not null,
    activa boolean not null,
    codi varchar(30) not null,
    identificador_codi varchar(4) not null,
    nif varchar(12) not null,
    nom varchar(30) not null,
    companyia_id bigint,
    primary key (id)
);

create table marcatge (
   id bigint not null,
    data timestamp not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version bigint not null,
    usuemp_id bigint not null,
    primary key (id)
);

create table usuari (
   id bigint not null,
    codi varchar(64) not null,
    contrasenya varchar(255),
    email varchar(100) not null,
    imatge_url varchar(255),
    nom varchar(100) not null,
    validat boolean,
    actiu boolean,
    version bigint not null,
    primary key (id)
);

create table usuari_empresa (
   id bigint not null,
    data_fi timestamp,
    data_inici timestamp not null,
    operari_codi varchar(6) not null,
    version bigint not null,
    usuari_id bigint not null,
    empresa_id bigint not null,
    primary key (id)
);

create table usuari_rols (
   usuari_id bigint not null,
    rol varchar(10)
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