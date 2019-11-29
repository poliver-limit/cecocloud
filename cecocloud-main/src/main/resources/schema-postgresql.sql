create sequence hibernate_sequence start 1 increment 1;
create sequence identificador_sequence start 1 increment 1;

create table companyia (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(30) not null,
    email varchar(120),
    llicencia varchar(2000),
    nom varchar(30) not null,
    telefon varchar(16),
    primary key (id)
);

create table empresa (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    activa boolean not null,
    codi varchar(4) not null,
    nif varchar(12) not null,
    nom varchar(30) not null,
    tipus int4 not null,
    identificador_id varchar(255),
    primary key (id)
);

create table identificador (
   id varchar(4) not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    actiu boolean not null,
    nom varchar(40) not null,
    companyia_id int8,
    primary key (id)
);

create table perfil (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(30) not null,
    descripcio varchar(255) not null,
    companyia_id int8,
    primary key (id)
);

create table perfil_rol (
   perfil_id int8 not null,
    rol_id int8 not null,
    version int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    primary key (perfil_id, rol_id)
);

create table perfil_usuariempresa (
   empresa_id int8 not null,
    perfil_id int8 not null,
    usuari_id int8 not null,
    version int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    primary key (empresa_id, perfil_id, usuari_id)
);

create table rol (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(30) not null,
    descripcio varchar(255) not null,
    companyia_id int8,
    primary key (id)
);

create table rol_usuariempresa (
   empresa_id int8 not null,
    rol_id int8 not null,
    usuari_id int8 not null,
    version int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    primary key (empresa_id, rol_id, usuari_id)
);

create table usuari (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    actiu boolean,
    codi varchar(64) not null,
    contrasenya varchar(255),
    email varchar(100) not null,
    imatge_url varchar(255),
    llinatges varchar(100) not null,
    nom varchar(100) not null,
    validat boolean,
    primary key (id)
);

create table usuari_authority (
   usuari_id int8 not null,
    rol varchar(10)
);

create table usuari_companyia (
   companyia_id int8 not null,
    usuari_id int8 not null,
    version int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    primary key (companyia_id, usuari_id)
);

create table usuari_empresa (
   empresa_id int8 not null,
    usuari_id int8 not null,
    version int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    primary key (empresa_id, usuari_id)
);

alter table companyia 
   add constraint companyia_codi_uk unique (codi);

alter table empresa 
   add constraint empresa_uk unique (identificador_id, codi);

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

create table acl_sid(
    id bigserial not null primary key,
    principal boolean not null,
    sid varchar(100) not null,
    constraint aclsid_uk unique(sid,principal)
);

create table acl_class(
    id bigserial not null primary key,
    class varchar(100) not null,
    constraint aclclass_uk unique(class)
);

create table acl_object_identity(
    id bigserial primary key,
    object_id_class bigint not null,
    object_id_identity varchar(36) not null,
    parent_object bigint,
    owner_sid bigint,
    entries_inheriting boolean not null,
    constraint acloid_uk unique(object_id_class,object_id_identity),
    constraint acloid_acloid_fk_1 foreign key(parent_object)references acl_object_identity(id),
    constraint acloid_aclclass_fk_2 foreign key(object_id_class)references acl_class(id),
    constraint acloid_aclsid_fk_3 foreign key(owner_sid)references acl_sid(id)
);

create table acl_entry(
    id bigserial primary key,
    acl_object_identity bigint not null,
    ace_order int not null,
    sid bigint not null,
    mask integer not null,
    granting boolean not null,
    audit_success boolean not null,
    audit_failure boolean not null,
    constraint aclentry_uk unique(acl_object_identity,ace_order),
    constraint aclentry_acloid_fk foreign key(acl_object_identity) references acl_object_identity(id),
    constraint aclentry_aclsid_fk foreign key(sid) references acl_sid(id)
);
